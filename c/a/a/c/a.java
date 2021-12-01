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
    public static a f1063f;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, d> a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.a.b.d f1064b;

    /* renamed from: c  reason: collision with root package name */
    public ExecutorService f1065c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.a.c.c.c f1066d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f1067e;

    /* renamed from: c.a.a.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0007a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f1068e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f1069f;

        public RunnableC0007a(a aVar, String str) {
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
            this.f1069f = aVar;
            this.f1068e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f1069f.a.containsKey(this.f1068e)) {
                this.f1069f.a.remove(this.f1068e);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f1070e;

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
            this.f1070e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (d dVar : this.f1070e.a.values()) {
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
        public final /* synthetic */ a f1071e;

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
            this.f1071e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                for (d dVar : this.f1071e.a.values()) {
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
        this.f1067e = new Handler(Looper.getMainLooper());
        this.a = new LinkedHashMap();
        j(new b.a.a.b.d());
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f1063f == null) {
                synchronized (a.class) {
                    if (f1063f == null) {
                        f1063f = new a();
                    }
                }
            }
            return f1063f;
        }
        return (a) invokeV.objValue;
    }

    @Override // c.a.a.c.c.d.a
    public void a(String str, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, dVar) == null) {
            this.f1067e.post(new RunnableC0007a(this, str));
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            String e2 = e(str);
            if (this.a.containsKey(e2)) {
                d dVar = this.a.get(e2);
                if (dVar != null) {
                    dVar.cancel();
                }
                this.a.remove(e2);
            }
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f1067e.post(new c(this));
        }
    }

    public void delete(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public final String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str != null) {
                return String.valueOf(str.hashCode());
            }
            throw new IllegalArgumentException("Tag can't be null!");
        }
        return (String) invokeL.objValue;
    }

    public void f(c.a.a.c.b bVar, String str, c.a.a.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, bVar, str, aVar) == null) {
            String e2 = e(str);
            if (k(e2)) {
                return;
            }
            g gVar = new g(bVar, new b.a.a.b.c.a(this.f1066d, aVar), this.f1065c, e2, this.f1064b, this);
            this.a.put(e2, gVar);
            gVar.start();
        }
    }

    public final void g(c.a.a.c.b bVar, String str, c.a.a.c.c.a aVar, c.a.a.c.c.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, bVar, str, aVar, cVar) == null) {
            String e2 = e(str);
            if (k(e2)) {
                return;
            }
            g gVar = new g(bVar, new b.a.a.b.c.a(cVar, aVar), this.f1065c, e2, this.f1064b, this);
            this.a.put(e2, gVar);
            gVar.start();
        }
    }

    public void h(String str, String str2, String str3, Looper looper, c.a.a.c.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, str3, looper, aVar) == null) {
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
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dVar) == null) {
            int i2 = dVar.f1042b;
            int i3 = dVar.a;
            if (i2 <= i3) {
                this.f1064b = dVar;
                this.f1065c = Executors.newFixedThreadPool(i3);
                this.f1066d = new h(this.f1067e);
                return;
            }
            throw new IllegalArgumentException("thread num must < max thread num");
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        d dVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (!this.a.containsKey(str) || (dVar = this.a.get(str)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            String e2 = e(str);
            if (!this.a.containsKey(e2) || (dVar = this.a.get(e2)) == null) {
                return false;
            }
            return dVar.isRunning();
        }
        return invokeL.booleanValue;
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            String e2 = e(str);
            if (this.a.containsKey(e2)) {
                d dVar = this.a.get(e2);
                if (dVar != null && dVar.isRunning()) {
                    dVar.pause();
                }
                this.a.remove(e2);
            }
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f1067e.post(new b(this));
        }
    }
}
