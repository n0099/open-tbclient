package c.a.r0.b0;

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
    public static final ThreadLocal<a> f14645g;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleArrayMap<b, Long> a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f14646b;

    /* renamed from: c  reason: collision with root package name */
    public final C0890a f14647c;

    /* renamed from: d  reason: collision with root package name */
    public c f14648d;

    /* renamed from: e  reason: collision with root package name */
    public long f14649e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14650f;

    /* renamed from: c.a.r0.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0890a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0890a(a aVar) {
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
            this.a = aVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f14649e = SystemClock.uptimeMillis();
                a aVar = this.a;
                aVar.h(aVar.f14649e);
                if (this.a.f14646b.size() > 0) {
                    this.a.j().a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean a(long j2);
    }

    /* loaded from: classes5.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final C0890a a;

        public c(C0890a c0890a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0890a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c0890a;
        }

        public abstract void a();
    }

    /* loaded from: classes5.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f14651b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f14652c;

        /* renamed from: d  reason: collision with root package name */
        public long f14653d;

        /* renamed from: c.a.r0.b0.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0891a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f14654e;

            public RunnableC0891a(d dVar) {
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
                this.f14654e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f14654e.f14653d = SystemClock.uptimeMillis();
                    this.f14654e.a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C0890a c0890a) {
            super(c0890a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0890a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C0890a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14653d = -1L;
            this.f14651b = new RunnableC0891a(this);
            this.f14652c = new Handler(Looper.myLooper());
        }

        @Override // c.a.r0.b0.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14652c.postDelayed(this.f14651b, Math.max(10 - (SystemClock.uptimeMillis() - this.f14653d), 0L));
            }
        }
    }

    @RequiresApi(16)
    /* loaded from: classes5.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f14655b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f14656c;

        /* renamed from: c.a.r0.b0.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class Choreographer$FrameCallbackC0892a implements Choreographer.FrameCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f14657e;

            public Choreographer$FrameCallbackC0892a(e eVar) {
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
                this.f14657e = eVar;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                    this.f14657e.a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C0890a c0890a) {
            super(c0890a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0890a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C0890a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14655b = Choreographer.getInstance();
            this.f14656c = new Choreographer$FrameCallbackC0892a(this);
        }

        @Override // c.a.r0.b0.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14655b.postFrameCallback(this.f14656c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1780112304, "Lc/a/r0/b0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1780112304, "Lc/a/r0/b0/a;");
                return;
            }
        }
        f14645g = new ThreadLocal<>();
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
        this.a = new SimpleArrayMap<>();
        this.f14646b = new ArrayList<>();
        this.f14647c = new C0890a(this);
        this.f14649e = 0L;
        this.f14650f = false;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f14645g.get() == null) {
                f14645g.set(new a());
            }
            return f14645g.get();
        }
        return (a) invokeV.objValue;
    }

    public void f(b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, bVar, j2) == null) {
            if (this.f14646b.size() == 0) {
                j().a();
            }
            if (!this.f14646b.contains(bVar)) {
                this.f14646b.add(bVar);
            }
            if (j2 > 0) {
                this.a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j2));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f14650f) {
            for (int size = this.f14646b.size() - 1; size >= 0; size--) {
                if (this.f14646b.get(size) == null) {
                    this.f14646b.remove(size);
                }
            }
            this.f14650f = false;
        }
    }

    public final void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i2 = 0; i2 < this.f14646b.size(); i2++) {
                b bVar = this.f14646b.get(i2);
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
            if (this.f14648d == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f14648d = new e(this.f14647c);
                } else {
                    this.f14648d = new d(this.f14647c);
                }
            }
            return this.f14648d;
        }
        return (c) invokeV.objValue;
    }

    public final boolean k(b bVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, bVar, j2)) == null) {
            Long l = this.a.get(bVar);
            if (l == null) {
                return true;
            }
            if (l.longValue() < j2) {
                this.a.remove(bVar);
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.a.remove(bVar);
            int indexOf = this.f14646b.indexOf(bVar);
            if (indexOf >= 0) {
                this.f14646b.set(indexOf, null);
                this.f14650f = true;
            }
        }
    }
}
