package c.a.a.c;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.a.b.c.g;
import b.a.a.b.c.h;
import c.a.a.c.b;
import c.a.a.c.c.d;
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
/* loaded from: classes.dex */
public class a implements d.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static a f1590f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, d> f1591a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.a.b.d f1592b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f1593c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.a.c.c.c f1594d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f1595e;

    /* renamed from: c.a.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0013a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1596e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f1597f;

        public RunnableC0013a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1597f = aVar;
            this.f1596e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f1597f.f1591a.containsKey(this.f1596e)) {
                this.f1597f.f1591a.remove(this.f1596e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1598e;

        public b(a aVar) {
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
            this.f1598e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (d dVar : this.f1598e.f1591a.values()) {
                    if (dVar != null && dVar.isRunning()) {
                        dVar.pause();
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1599e;

        public c(a aVar) {
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
            this.f1599e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (d dVar : this.f1599e.f1591a.values()) {
                    if (dVar != null && dVar.isRunning()) {
                        dVar.cancel();
                    }
                }
            }
        }
    }

    public a() {
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
        this.f1595e = new Handler(Looper.getMainLooper());
        this.f1591a = new LinkedHashMap();
        j(new b.a.a.b.d());
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f1590f == null) {
                synchronized (a.class) {
                    if (f1590f == null) {
                        f1590f = new a();
                    }
                }
            }
            return f1590f;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.a.c.c.d.a
    public void a(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            this.f1595e.post(new RunnableC0013a(this, str));
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e2 = e(str);
            if (this.f1591a.containsKey(e2)) {
                d dVar = this.f1591a.get(e2);
                if (dVar != null) {
                    dVar.cancel();
                }
                this.f1591a.remove(e2);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1595e.post(new c(this));
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

    public void f(c.a.a.c.b bVar, String str, c.a.a.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, bVar, str, aVar) == null) {
            String e2 = e(str);
            if (k(e2)) {
                return;
            }
            g gVar = new g(bVar, new b.a.a.b.c.a(this.f1594d, aVar), this.f1593c, e2, this.f1592b, this);
            this.f1591a.put(e2, gVar);
            gVar.start();
        }
    }

    public final void g(c.a.a.c.b bVar, String str, c.a.a.c.c.a aVar, c.a.a.c.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, bVar, str, aVar, cVar) == null) {
            String e2 = e(str);
            if (k(e2)) {
                return;
            }
            g gVar = new g(bVar, new b.a.a.b.c.a(cVar, aVar), this.f1593c, e2, this.f1592b, this);
            this.f1591a.put(e2, gVar);
            gVar.start();
        }
    }

    public void h(String str, String str2, String str3, Looper looper, c.a.a.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048582, this, str, str2, str3, looper, aVar) == null) {
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            b.a aVar2 = new b.a();
            aVar2.d(str);
            aVar2.b(new File(str2));
            aVar2.c(str3);
            g(aVar2.a(), str, aVar, new h(new Handler(looper)));
        }
    }

    public final void j(@NonNull b.a.a.b.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dVar) == null) {
            int i2 = dVar.f1563b;
            int i3 = dVar.f1562a;
            if (i2 <= i3) {
                this.f1592b = dVar;
                this.f1593c = Executors.newFixedThreadPool(i3);
                this.f1594d = new h(this.f1595e);
                return;
            }
            throw new IllegalArgumentException("thread num must < max thread num");
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (!this.f1591a.containsKey(str) || (dVar = this.f1591a.get(str)) == null) {
                return false;
            }
            if (dVar.isRunning()) {
                c.a.a.c.d.c.c("DownloadInfo has been started!");
                return true;
            }
            c.a.a.c.d.c.c("DownloadInfo not started!");
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean l(String str) {
        InterceptResult invokeL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            String e2 = e(str);
            if (!this.f1591a.containsKey(e2) || (dVar = this.f1591a.get(e2)) == null) {
                return false;
            }
            return dVar.isRunning();
        }
        return invokeL.booleanValue;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            String e2 = e(str);
            if (this.f1591a.containsKey(e2)) {
                d dVar = this.f1591a.get(e2);
                if (dVar != null && dVar.isRunning()) {
                    dVar.pause();
                }
                this.f1591a.remove(e2);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.f1595e.post(new b(this));
        }
    }
}
