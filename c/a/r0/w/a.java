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
    public static final ThreadLocal<a> f26395g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f26396a;

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f26397b;

    /* renamed from: c  reason: collision with root package name */
    public final C1236a f26398c;

    /* renamed from: d  reason: collision with root package name */
    public c f26399d;

    /* renamed from: e  reason: collision with root package name */
    public long f26400e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f26401f;

    /* renamed from: c.a.r0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1236a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f26402a;

        public C1236a(a aVar) {
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
            this.f26402a = aVar;
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26402a.f26400e = SystemClock.uptimeMillis();
                a aVar = this.f26402a;
                aVar.h(aVar.f26400e);
                if (this.f26402a.f26397b.size() > 0) {
                    this.f26402a.j().a();
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
        public final C1236a f26403a;

        public c(C1236a c1236a) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1236a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26403a = c1236a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f26404b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f26405c;

        /* renamed from: d  reason: collision with root package name */
        public long f26406d;

        /* renamed from: c.a.r0.w.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1237a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ d f26407e;

            public RunnableC1237a(d dVar) {
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
                this.f26407e = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f26407e.f26406d = SystemClock.uptimeMillis();
                    this.f26407e.f26403a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(C1236a c1236a) {
            super(c1236a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1236a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1236a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26406d = -1L;
            this.f26404b = new RunnableC1237a(this);
            this.f26405c = new Handler(Looper.myLooper());
        }

        @Override // c.a.r0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26405c.postDelayed(this.f26404b, Math.max(10 - (SystemClock.uptimeMillis() - this.f26406d), 0L));
            }
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f26408b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f26409c;

        /* renamed from: c.a.r0.w.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1238a implements Choreographer.FrameCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ e f26410e;

            public Choreographer$FrameCallbackC1238a(e eVar) {
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
                this.f26410e = eVar;
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
                    this.f26410e.f26403a.a();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C1236a c1236a) {
            super(c1236a);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1236a};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((C1236a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26408b = Choreographer.getInstance();
            this.f26409c = new Choreographer$FrameCallbackC1238a(this);
        }

        @Override // c.a.r0.w.a.c
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f26408b.postFrameCallback(this.f26409c);
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
        f26395g = new ThreadLocal<>();
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
        this.f26396a = new SimpleArrayMap<>();
        this.f26397b = new ArrayList<>();
        this.f26398c = new C1236a(this);
        this.f26400e = 0L;
        this.f26401f = false;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f26395g.get() == null) {
                f26395g.set(new a());
            }
            return f26395g.get();
        }
        return (a) invokeV.objValue;
    }

    public void f(b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048576, this, bVar, j2) == null) {
            if (this.f26397b.size() == 0) {
                j().a();
            }
            if (!this.f26397b.contains(bVar)) {
                this.f26397b.add(bVar);
            }
            if (j2 > 0) {
                this.f26396a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j2));
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.f26401f) {
            for (int size = this.f26397b.size() - 1; size >= 0; size--) {
                if (this.f26397b.get(size) == null) {
                    this.f26397b.remove(size);
                }
            }
            this.f26401f = false;
        }
    }

    public final void h(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i2 = 0; i2 < this.f26397b.size(); i2++) {
                b bVar = this.f26397b.get(i2);
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
            if (this.f26399d == null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    this.f26399d = new e(this.f26398c);
                } else {
                    this.f26399d = new d(this.f26398c);
                }
            }
            return this.f26399d;
        }
        return (c) invokeV.objValue;
    }

    public final boolean k(b bVar, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048580, this, bVar, j2)) == null) {
            Long l = this.f26396a.get(bVar);
            if (l == null) {
                return true;
            }
            if (l.longValue() < j2) {
                this.f26396a.remove(bVar);
                return true;
            }
            return false;
        }
        return invokeLJ.booleanValue;
    }

    public void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f26396a.remove(bVar);
            int indexOf = this.f26397b.indexOf(bVar);
            if (indexOf >= 0) {
                this.f26397b.set(indexOf, null);
                this.f26401f = true;
            }
        }
    }
}
