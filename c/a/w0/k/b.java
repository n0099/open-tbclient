package c.a.w0.k;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.w0.k.c;
import c.a.w0.k.e.f;
import c.a.w0.k.f.e;
import c.a.w0.t.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes4.dex */
public class b implements f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static b f30608f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, f> f30609a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.w0.k.a f30610b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f30611c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.w0.k.e.d f30612d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f30613e;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f30614e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f30615f;

        public a(b bVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30615f = bVar;
            this.f30614e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f30615f.f30609a.containsKey(this.f30614e)) {
                this.f30615f.f30609a.remove(this.f30614e);
            }
        }
    }

    /* renamed from: c.a.w0.k.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1421b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30616e;

        public RunnableC1421b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30616e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (f fVar : this.f30616e.f30609a.values()) {
                    if (fVar != null && fVar.isRunning()) {
                        fVar.pause();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f30617e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30617e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (f fVar : this.f30617e.f30609a.values()) {
                    if (fVar != null && fVar.isRunning()) {
                        fVar.cancel();
                    }
                }
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f30613e = new Handler(Looper.getMainLooper());
        this.f30609a = new LinkedHashMap();
        i(new c.a.w0.k.a());
    }

    public static b h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f30608f == null) {
                synchronized (b.class) {
                    if (f30608f == null) {
                        f30608f = new b();
                    }
                }
            }
            return f30608f;
        }
        return (b) invokeV.objValue;
    }

    @Override // c.a.w0.k.e.f.a
    public void a(String str, f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, fVar) == null) {
            this.f30613e.post(new a(this, str));
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e2 = e(str);
            if (this.f30609a.containsKey(e2)) {
                f fVar = this.f30609a.get(e2);
                if (fVar != null) {
                    fVar.cancel();
                }
                this.f30609a.remove(e2);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f30613e.post(new c(this));
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str != null) {
                return String.valueOf(str.hashCode());
            }
            throw new IllegalArgumentException("Tag can't be null!");
        }
        return (String) invokeL.objValue;
    }

    public void f(c.a.w0.k.c cVar, String str, c.a.w0.k.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, cVar, str, aVar) == null) {
            String e2 = e(str);
            if (j(e2)) {
                return;
            }
            e eVar = new e(cVar, new c.a.w0.k.f.b(this.f30612d, aVar), this.f30611c, e2, this.f30610b, this);
            this.f30609a.put(e2, eVar);
            eVar.start();
        }
    }

    public void g(String str, String str2, String str3, c.a.w0.k.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, str, str2, str3, aVar) == null) {
            c.b bVar = new c.b();
            bVar.d(str);
            bVar.b(new File(str2));
            bVar.c(str3);
            f(bVar.a(), str, aVar);
        }
    }

    public final void i(@NonNull c.a.w0.k.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, aVar) == null) {
            if (aVar.b() <= aVar.a()) {
                this.f30610b = aVar;
                this.f30611c = Executors.newFixedThreadPool(aVar.a());
                this.f30612d = new c.a.w0.k.f.c(this.f30613e);
                return;
            }
            throw new IllegalArgumentException("thread num must < max thread num");
        }
    }

    public final boolean j(String str) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.f30609a.containsKey(str) && (fVar = this.f30609a.get(str)) != null && fVar.isRunning()) {
                i.d("DownloadInfo has been started!");
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k(String str) {
        InterceptResult invokeL;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            String e2 = e(str);
            if (!this.f30609a.containsKey(e2) || (fVar = this.f30609a.get(e2)) == null) {
                return false;
            }
            return fVar.isRunning();
        }
        return invokeL.booleanValue;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            String e2 = e(str);
            if (this.f30609a.containsKey(e2)) {
                f fVar = this.f30609a.get(e2);
                if (fVar != null && fVar.isRunning()) {
                    fVar.pause();
                }
                this.f30609a.remove(e2);
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f30613e.post(new RunnableC1421b(this));
        }
    }
}
