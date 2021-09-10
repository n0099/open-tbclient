package c.p.a.e.b.m;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
/* loaded from: classes4.dex */
public class h extends c.p.a.e.b.g.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String m = "h";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1473299823, "Lc/p/a/e/b/m/h;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1473299823, "Lc/p/a/e/b/m/h;");
        }
    }

    public h() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // c.p.a.e.b.g.c, c.p.a.e.b.g.p
    public void a(Intent intent, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, intent, i2, i3) == null) {
            if (c.p.a.e.b.c.a.e()) {
                c.p.a.e.b.c.a.g(m, "onStartCommand");
            }
            if (!c.p.a.e.b.l.a.a(262144)) {
                this.f35101g = true;
            }
            g();
        }
    }

    @Override // c.p.a.e.b.g.c, c.p.a.e.b.g.p
    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && c.p.a.e.b.l.a.a(262144)) {
            this.f35101g = true;
            this.f35103i = false;
            if (c.p.a.e.b.c.a.e()) {
                c.p.a.e.b.c.a.g(m, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // c.p.a.e.b.g.c
    public void e(Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, serviceConnection) == null) {
            try {
                context.startService(new Intent(context, DownloadService.class));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
