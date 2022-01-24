package c.a.d.f.d;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.d.e;
import c.a.d.f.d.l;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class m<T> implements l.c<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public final k<T> f2832b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2833c;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f2834e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l.a f2835f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f2836g;

        public a(m mVar, String str, l.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, str, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2836g = mVar;
            this.f2834e = str;
            this.f2835f = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: c.a.d.f.d.l$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2835f.a(this.f2834e, this.f2836g.get(this.f2834e));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f2837e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Object f2838f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ long f2839g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ m f2840h;

        public b(m mVar, String str, Object obj, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, str, obj, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2840h = mVar;
            this.f2837e = str;
            this.f2838f = obj;
            this.f2839g = j2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: c.a.d.f.d.m */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2840h.e(this.f2837e, this.f2838f, this.f2839g);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f2841e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f2842f;

        public c(m mVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2842f = mVar;
            this.f2841e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2842f.remove(this.f2841e);
            }
        }
    }

    public m(String str, k<T> kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, kVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f2833c = str;
        this.f2832b = kVar;
    }

    @Override // c.a.d.f.d.l
    public void a(String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, t) == null) {
            i(str, t, 315532800000L);
        }
    }

    @Override // c.a.d.f.d.l.c
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f2832b.g(this.f2833c);
            l();
        }
    }

    @Override // c.a.d.f.d.l.c
    public k<T> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2832b : (k) invokeV.objValue;
    }

    @Override // c.a.d.f.d.l
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            c.a.d.f.m.h.a().b(new c(this, str));
        }
    }

    @Override // c.a.d.f.d.l
    public void e(String str, T t, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, t, Long.valueOf(j2)}) == null) {
            if (str != null) {
                if (j2 <= 315532800000L) {
                    j2 += System.currentTimeMillis();
                }
                long j3 = j2;
                if (j3 <= System.currentTimeMillis()) {
                    remove(str);
                    return;
                } else {
                    this.f2832b.f(this.f2833c, str, t, j3);
                    return;
                }
            }
            throw new NullPointerException("BdKVCache key cannot be null!");
        }
    }

    @Override // c.a.d.f.d.l
    public void f(String str, l.a<T> aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, aVar) == null) {
            c.a.d.f.m.h.a().b(new a(this, str, aVar));
        }
    }

    @Override // c.a.d.f.d.l
    public void g(String str, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, t) == null) {
            e(str, t, 315532800000L);
        }
    }

    @Override // c.a.d.f.d.l
    public T get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (BdBaseApplication.getInst().isDebugMode() && c.a.d.f.p.n.B()) {
                if (!this.a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            return this.f2832b.a(this.f2833c, str);
        }
        return (T) invokeL.objValue;
    }

    @Override // c.a.d.f.d.l
    public l.b<T> h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (BdBaseApplication.getInst().isDebugMode() && c.a.d.f.p.n.B()) {
                if (!this.a) {
                    BdLog.detailException("access db in main thread!", new Exception());
                } else {
                    throw new RuntimeException("access db in main thread!");
                }
            }
            return this.f2832b.e(this.f2833c, str);
        }
        return (l.b) invokeL.objValue;
    }

    @Override // c.a.d.f.d.l
    public void i(String str, T t, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, t, Long.valueOf(j2)}) == null) {
            c.a.d.f.m.h.a().b(new b(this, str, t, j2));
        }
    }

    @Override // c.a.d.f.d.l.c
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2833c : (String) invokeV.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f2832b.b(this.f2833c);
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e c2 = c().c();
            if (c2 instanceof e.b) {
                ((e.b) c2).release();
            }
        }
    }

    @Override // c.a.d.f.d.l
    public void remove(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.f2832b.d(this.f2833c, str);
        }
    }
}
