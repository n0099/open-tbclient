package c.a.p0.d0;

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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<a> f13585g;
    public transient /* synthetic */ FieldHolder $fh;
    public final SimpleArrayMap<b, Long> a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f13586b;

    /* renamed from: c  reason: collision with root package name */
    public final C1023a f13587c;

    /* renamed from: d  reason: collision with root package name */
    public c f13588d;

    /* renamed from: e  reason: collision with root package name */
    public long f13589e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13590f;

    /* renamed from: c.a.p0.d0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C1023a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1023a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.f13589e = SystemClock.uptimeMillis();
                a aVar = this.a;
                aVar.h(aVar.f13589e);
                if (this.a.f13586b.size() > 0) {
                    this.a.j().a();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        boolean a(long j);
    }

    /* loaded from: classes2.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final C1023a a;

        public c(C1023a c1023a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1023a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c1023a;
        }

        public abstract void a();
    }

    /* loaded from: classes2.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f13591b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f13592c;

        /* renamed from: d  reason: collision with root package name */
        public long f13593d;

        /* renamed from: c.a.p0.d0.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC1024a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public RunnableC1024a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.f13593d = SystemClock.uptimeMillis();
                    this.a.a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C1023a c1023a) {
            super(c1023a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1023a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((C1023a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13593d = -1L;
            this.f13591b = new RunnableC1024a(this);
            this.f13592c = new Handler(Looper.myLooper());
        }

        @Override // c.a.p0.d0.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13592c.postDelayed(this.f13591b, Math.max(10 - (SystemClock.uptimeMillis() - this.f13593d), 0L));
            }
        }
    }

    @RequiresApi(16)
    /* loaded from: classes2.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f13594b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f13595c;

        /* renamed from: c.a.p0.d0.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class Choreographer$FrameCallbackC1025a implements Choreographer.FrameCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ e a;

            public Choreographer$FrameCallbackC1025a(e eVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {eVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = eVar;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                    this.a.a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C1023a c1023a) {
            super(c1023a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1023a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((C1023a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13594b = Choreographer.getInstance();
            this.f13595c = new Choreographer$FrameCallbackC1025a(this);
        }

        @Override // c.a.p0.d0.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f13594b.postFrameCallback(this.f13595c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1703661324, "Lc/a/p0/d0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1703661324, "Lc/a/p0/d0/a;");
                return;
            }
        }
        f13585g = new ThreadLocal<>();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new SimpleArrayMap<>();
        this.f13586b = new ArrayList<>();
        this.f13587c = new C1023a(this);
        this.f13589e = 0L;
        this.f13590f = false;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f13585g.get() == null) {
                f13585g.set(new a());
            }
            return f13585g.get();
        }
        return (a) invokeV.objValue;
    }

    public void f(b bVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, bVar, j) == null) {
            if (this.f13586b.size() == 0) {
                j().a();
            }
            if (!this.f13586b.contains(bVar)) {
                this.f13586b.add(bVar);
            }
            if (j > 0) {
                this.a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f13590f) {
            for (int size = this.f13586b.size() - 1; size >= 0; size--) {
                if (this.f13586b.get(size) == null) {
                    this.f13586b.remove(size);
                }
            }
            this.f13590f = false;
        }
    }

    public final void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i = 0; i < this.f13586b.size(); i++) {
                b bVar = this.f13586b.get(i);
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
            if (this.f13588d == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f13588d = new e(this.f13587c);
                } else {
                    this.f13588d = new d(this.f13587c);
                }
            }
            return this.f13588d;
        }
        return (c) invokeV.objValue;
    }

    public final boolean k(b bVar, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, bVar, j)) == null) {
            Long l = this.a.get(bVar);
            if (l == null) {
                return true;
            }
            if (l.longValue() < j) {
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
            int indexOf = this.f13586b.indexOf(bVar);
            if (indexOf >= 0) {
                this.f13586b.set(indexOf, null);
                this.f13590f = true;
            }
        }
    }
}
