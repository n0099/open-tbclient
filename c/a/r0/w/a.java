package c.a.r0.w;

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
    public static final ThreadLocal<a> f26372g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f26373a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f26374b;

    /* renamed from: c  reason: collision with root package name */
    public final C1238a f26375c;

    /* renamed from: d  reason: collision with root package name */
    public c f26376d;

    /* renamed from: e  reason: collision with root package name */
    public long f26377e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26378f;

    /* renamed from: c.a.r0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1238a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26379a;

        public C1238a(a aVar) {
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
            this.f26379a = aVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26379a.f26377e = SystemClock.uptimeMillis();
                a aVar = this.f26379a;
                aVar.h(aVar.f26377e);
                if (this.f26379a.f26374b.size() > 0) {
                    this.f26379a.j().a();
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
        public final C1238a f26380a;

        public c(C1238a c1238a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1238a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26380a = c1238a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f26381b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f26382c;

        /* renamed from: d  reason: collision with root package name */
        public long f26383d;

        /* renamed from: c.a.r0.w.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1239a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f26384e;

            public RunnableC1239a(d dVar) {
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
                this.f26384e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f26384e.f26383d = SystemClock.uptimeMillis();
                    this.f26384e.f26380a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C1238a c1238a) {
            super(c1238a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1238a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1238a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26383d = -1L;
            this.f26381b = new RunnableC1239a(this);
            this.f26382c = new Handler(Looper.myLooper());
        }

        @Override // c.a.r0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26382c.postDelayed(this.f26381b, Math.max(10 - (SystemClock.uptimeMillis() - this.f26383d), 0L));
            }
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f26385b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f26386c;

        /* renamed from: c.a.r0.w.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1240a implements Choreographer.FrameCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f26387e;

            public Choreographer$FrameCallbackC1240a(e eVar) {
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
                this.f26387e = eVar;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                    this.f26387e.f26380a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C1238a c1238a) {
            super(c1238a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1238a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1238a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26385b = Choreographer.getInstance();
            this.f26386c = new Choreographer$FrameCallbackC1240a(this);
        }

        @Override // c.a.r0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26385b.postFrameCallback(this.f26386c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-634687523, "Lc/a/r0/w/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-634687523, "Lc/a/r0/w/a;");
                return;
            }
        }
        f26372g = new ThreadLocal<>();
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
        this.f26373a = new SimpleArrayMap<>();
        this.f26374b = new ArrayList<>();
        this.f26375c = new C1238a(this);
        this.f26377e = 0L;
        this.f26378f = false;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f26372g.get() == null) {
                f26372g.set(new a());
            }
            return f26372g.get();
        }
        return (a) invokeV.objValue;
    }

    public void f(b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, bVar, j2) == null) {
            if (this.f26374b.size() == 0) {
                j().a();
            }
            if (!this.f26374b.contains(bVar)) {
                this.f26374b.add(bVar);
            }
            if (j2 > 0) {
                this.f26373a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j2));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f26378f) {
            for (int size = this.f26374b.size() - 1; size >= 0; size--) {
                if (this.f26374b.get(size) == null) {
                    this.f26374b.remove(size);
                }
            }
            this.f26378f = false;
        }
    }

    public final void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i2 = 0; i2 < this.f26374b.size(); i2++) {
                b bVar = this.f26374b.get(i2);
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
            if (this.f26376d == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f26376d = new e(this.f26375c);
                } else {
                    this.f26376d = new d(this.f26375c);
                }
            }
            return this.f26376d;
        }
        return (c) invokeV.objValue;
    }

    public final boolean k(b bVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, bVar, j2)) == null) {
            Long l = this.f26373a.get(bVar);
            if (l == null) {
                return true;
            }
            if (l.longValue() < j2) {
                this.f26373a.remove(bVar);
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f26373a.remove(bVar);
            int indexOf = this.f26374b.indexOf(bVar);
            if (indexOf >= 0) {
                this.f26374b.set(indexOf, null);
                this.f26378f = true;
            }
        }
    }
}
