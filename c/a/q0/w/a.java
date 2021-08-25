package c.a.q0.w;

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
    public static final ThreadLocal<a> f27576g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f27577a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f27578b;

    /* renamed from: c  reason: collision with root package name */
    public final C1292a f27579c;

    /* renamed from: d  reason: collision with root package name */
    public c f27580d;

    /* renamed from: e  reason: collision with root package name */
    public long f27581e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f27582f;

    /* renamed from: c.a.q0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1292a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f27583a;

        public C1292a(a aVar) {
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
            this.f27583a = aVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27583a.f27581e = SystemClock.uptimeMillis();
                a aVar = this.f27583a;
                aVar.h(aVar.f27581e);
                if (this.f27583a.f27578b.size() > 0) {
                    this.f27583a.j().a();
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
        public final C1292a f27584a;

        public c(C1292a c1292a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1292a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27584a = c1292a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f27585b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f27586c;

        /* renamed from: d  reason: collision with root package name */
        public long f27587d;

        /* renamed from: c.a.q0.w.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1293a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f27588e;

            public RunnableC1293a(d dVar) {
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
                this.f27588e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f27588e.f27587d = SystemClock.uptimeMillis();
                    this.f27588e.f27584a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C1292a c1292a) {
            super(c1292a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1292a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1292a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27587d = -1L;
            this.f27585b = new RunnableC1293a(this);
            this.f27586c = new Handler(Looper.myLooper());
        }

        @Override // c.a.q0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27586c.postDelayed(this.f27585b, Math.max(10 - (SystemClock.uptimeMillis() - this.f27587d), 0L));
            }
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f27589b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f27590c;

        /* renamed from: c.a.q0.w.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1294a implements Choreographer.FrameCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f27591e;

            public Choreographer$FrameCallbackC1294a(e eVar) {
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
                this.f27591e = eVar;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                    this.f27591e.f27584a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C1292a c1292a) {
            super(c1292a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1292a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1292a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f27589b = Choreographer.getInstance();
            this.f27590c = new Choreographer$FrameCallbackC1294a(this);
        }

        @Override // c.a.q0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f27589b.postFrameCallback(this.f27590c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1522191204, "Lc/a/q0/w/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1522191204, "Lc/a/q0/w/a;");
                return;
            }
        }
        f27576g = new ThreadLocal<>();
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
        this.f27577a = new SimpleArrayMap<>();
        this.f27578b = new ArrayList<>();
        this.f27579c = new C1292a(this);
        this.f27581e = 0L;
        this.f27582f = false;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f27576g.get() == null) {
                f27576g.set(new a());
            }
            return f27576g.get();
        }
        return (a) invokeV.objValue;
    }

    public void f(b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, bVar, j2) == null) {
            if (this.f27578b.size() == 0) {
                j().a();
            }
            if (!this.f27578b.contains(bVar)) {
                this.f27578b.add(bVar);
            }
            if (j2 > 0) {
                this.f27577a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j2));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f27582f) {
            for (int size = this.f27578b.size() - 1; size >= 0; size--) {
                if (this.f27578b.get(size) == null) {
                    this.f27578b.remove(size);
                }
            }
            this.f27582f = false;
        }
    }

    public final void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i2 = 0; i2 < this.f27578b.size(); i2++) {
                b bVar = this.f27578b.get(i2);
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
            if (this.f27580d == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f27580d = new e(this.f27579c);
                } else {
                    this.f27580d = new d(this.f27579c);
                }
            }
            return this.f27580d;
        }
        return (c) invokeV.objValue;
    }

    public final boolean k(b bVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, bVar, j2)) == null) {
            Long l = this.f27577a.get(bVar);
            if (l == null) {
                return true;
            }
            if (l.longValue() < j2) {
                this.f27577a.remove(bVar);
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f27577a.remove(bVar);
            int indexOf = this.f27578b.indexOf(bVar);
            if (indexOf >= 0) {
                this.f27578b.set(indexOf, null);
                this.f27582f = true;
            }
        }
    }
}
