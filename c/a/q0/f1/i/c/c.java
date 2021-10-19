package c.a.q0.f1.i.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import c.a.q0.f1.i.a.a;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final c.a.q0.f1.i.a.b f13218a;

    /* renamed from: b  reason: collision with root package name */
    public final BitmapRegionDecoder f13219b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.e.e.k.a<a.C0656a, c.a.q0.f1.i.a.a> f13220c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.e.e.k.b<c.a.q0.f1.i.a.a> f13221d;

    /* renamed from: e  reason: collision with root package name */
    public final ThreadPoolExecutor f13222e;

    /* renamed from: f  reason: collision with root package name */
    public BdAsyncTask<Void, Void, Void> f13223f;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f13224a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13224a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void[] voidArr) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                try {
                    this.f13224a.f13222e.shutdownNow();
                    this.f13224a.f13222e.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.f13224a.f13219b != null) {
                    this.f13224a.f13219b.recycle();
                    return null;
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements RejectedExecutionHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, runnable, threadPoolExecutor) == null) {
            }
        }
    }

    /* renamed from: c.a.q0.f1.i.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0658c extends c.a.e.e.k.a<a.C0656a, c.a.q0.f1.i.a.a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f13225h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0658c(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13225h = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.a
        /* renamed from: o */
        public void b(boolean z, a.C0656a c0656a, c.a.q0.f1.i.a.a aVar, c.a.q0.f1.i.a.a aVar2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), c0656a, aVar, aVar2}) == null) || !z || this.f13225h.f13221d == null || aVar == null) {
                return;
            }
            aVar.a();
            this.f13225h.f13221d.e(aVar);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.a
        /* renamed from: p */
        public int m(a.C0656a c0656a, c.a.q0.f1.i.a.a aVar) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, c0656a, aVar)) == null) {
                if (aVar == null) {
                    return 0;
                }
                return BitmapHelper.getBitmapSize(aVar.b());
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f13226e;

        /* renamed from: f  reason: collision with root package name */
        public int f13227f;

        /* renamed from: g  reason: collision with root package name */
        public int f13228g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.q0.f1.i.a.b f13229h;

        /* renamed from: i  reason: collision with root package name */
        public BitmapRegionDecoder f13230i;

        /* renamed from: j  reason: collision with root package name */
        public c.a.e.e.k.a<a.C0656a, c.a.q0.f1.i.a.a> f13231j;
        public c.a.q0.f1.i.b.a k;
        public c l;

        public d(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f13226e = i2;
            this.f13227f = i3;
            this.f13228g = i4;
        }

        public final void b(c cVar, c.a.q0.f1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder, c.a.e.e.k.a<a.C0656a, c.a.q0.f1.i.a.a> aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, cVar, bVar, bitmapRegionDecoder, aVar) == null) {
                this.f13229h = bVar;
                this.f13230i = bitmapRegionDecoder;
                this.f13231j = aVar;
                this.l = cVar;
            }
        }

        public final boolean c(Rect rect) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rect)) == null) ? rect.right <= rect.left || rect.bottom <= rect.top : invokeL.booleanValue;
        }

        public void d(c.a.q0.f1.i.b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
                this.k = aVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            c.a.q0.f1.i.a.a c2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.f13231j != null && this.f13229h.b(this.f13226e, this.f13227f, this.f13228g)) {
                Rect j2 = this.f13229h.j(this.f13226e, this.f13227f, this.f13228g);
                this.f13229h.a(j2);
                if (c(j2)) {
                    return;
                }
                try {
                    c2 = this.l.f().b();
                    if (c2 != null) {
                        if (!c2.g(j2)) {
                            System.currentTimeMillis();
                            c2.a();
                        }
                    } else {
                        c2 = this.f13229h.c();
                    }
                } catch (Throwable unused) {
                    TbadkCoreApplication.getInst().onAppMemoryLow();
                    c.a.e.e.k.a<a.C0656a, c.a.q0.f1.i.a.a> aVar = this.f13231j;
                    aVar.k((int) (aVar.g() * 0.8d));
                    System.gc();
                    try {
                        c2 = this.f13229h.c();
                    } catch (Throwable unused2) {
                        return;
                    }
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = this.f13228g;
                options.inBitmap = c2.b();
                options.inMutable = true;
                System.currentTimeMillis();
                Bitmap decodeRegion = this.f13230i.decodeRegion(j2, options);
                if (decodeRegion == null) {
                    options.inBitmap = null;
                    decodeRegion = this.f13230i.decodeRegion(j2, options);
                    if (decodeRegion == null) {
                        return;
                    }
                }
                decodeRegion.prepareToDraw();
                c2.h(decodeRegion);
                c2.j(this.f13226e, this.f13227f, this.f13228g);
                this.f13231j.h(c2.d(), c2);
                c.a.q0.f1.i.b.a aVar2 = this.k;
                if (aVar2 != null) {
                    aVar2.onLoadFinished();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1752060028, "Lc/a/q0/f1/i/c/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1752060028, "Lc/a/q0/f1/i/c/c;");
        }
    }

    public c(c.a.q0.f1.i.a.b bVar, BitmapRegionDecoder bitmapRegionDecoder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bitmapRegionDecoder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f13218a = bVar;
        this.f13219b = bitmapRegionDecoder;
        c.a.q0.c0.c.k().u((int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.7f));
        this.f13222e = new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new b(this));
        this.f13220c = new C0658c(this, (int) (TbConfig.getBigImageMaxUsedMemoryForRemoteProcess() * 0.3f));
        c.a.e.e.k.b<c.a.q0.f1.i.a.a> p = c.a.q0.c0.c.k().p(this.f13218a.e());
        this.f13221d = p;
        p.f(6);
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f13222e.purge();
            if (z && this.f13223f == null) {
                a aVar = new a(this);
                this.f13223f = aVar;
                aVar.execute(new Void[0]);
            }
        }
    }

    public c.a.e.e.k.a<a.C0656a, c.a.q0.f1.i.a.a> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f13220c : (c.a.e.e.k.a) invokeV.objValue;
    }

    public c.a.e.e.k.b<c.a.q0.f1.i.a.a> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f13221d : (c.a.e.e.k.b) invokeV.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d(true);
            c.a.e.e.k.a<a.C0656a, c.a.q0.f1.i.a.a> aVar = this.f13220c;
            if (aVar != null) {
                aVar.k(0);
                this.f13220c.a();
                this.f13220c = null;
            }
            this.f13221d = null;
        }
    }

    public void h(d dVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) && dVar != null && this.f13223f == null) {
            dVar.b(this, this.f13218a, this.f13219b, e());
            this.f13222e.submit(dVar);
        }
    }
}
