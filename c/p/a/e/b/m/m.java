package c.p.a.e.b.m;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.i;
import java.util.List;
/* loaded from: classes4.dex */
public class m extends c.p.a.e.b.g.c implements ServiceConnection {
    public static /* synthetic */ Interceptable $ic;
    public static final String p;
    public transient /* synthetic */ FieldHolder $fh;
    public com.ss.android.socialbase.downloader.downloader.i m;
    public c.p.a.e.b.g.o n;
    public int o;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1473299668, "Lc/p/a/e/b/m/m;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1473299668, "Lc/p/a/e/b/m/m;");
                return;
            }
        }
        p = m.class.getSimpleName();
    }

    public m() {
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
        this.o = -1;
    }

    @Override // c.p.a.e.b.g.c, c.p.a.e.b.g.p
    public IBinder a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
                c.p.a.e.b.j.a.k("fix_sigbus_downloader_db", true);
            }
            c.p.a.e.b.c.a.g(p, "onBind IndependentDownloadBinder");
            return new com.ss.android.socialbase.downloader.impls.m();
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // c.p.a.e.b.g.c, c.p.a.e.b.g.p
    public void b(c.p.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        c.p.a.e.b.g.f.c().h(aVar.I(), true);
        a c2 = c.p.a.e.b.g.e.c();
        if (c2 != null) {
            c2.o(aVar);
        }
    }

    @Override // c.p.a.e.b.g.c, c.p.a.e.b.g.p
    public void d(c.p.a.e.b.g.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oVar) == null) {
            this.n = oVar;
        }
    }

    @Override // c.p.a.e.b.g.c
    public void e(Context context, ServiceConnection serviceConnection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, serviceConnection) == null) {
            try {
                c.p.a.e.b.c.a.g(p, "bindService");
                Intent intent = new Intent(context, IndependentProcessDownloadService.class);
                if (c.p.a.e.b.l.f.F()) {
                    intent.putExtra("fix_downloader_db_sigbus", c.p.a.e.b.j.a.r().l("fix_sigbus_downloader_db"));
                }
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // c.p.a.e.b.g.c, c.p.a.e.b.g.p
    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.m == null) {
            e(c.p.a.e.b.g.e.n(), this);
        }
    }

    public final void i() {
        SparseArray<List<c.p.a.e.b.n.a>> clone;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            try {
                synchronized (this.f35100f) {
                    clone = this.f35100f.clone();
                    this.f35100f.clear();
                }
                if (clone == null || clone.size() <= 0 || c.p.a.e.b.g.e.c() == null) {
                    return;
                }
                for (int i2 = 0; i2 < clone.size(); i2++) {
                    List<c.p.a.e.b.n.a> list = clone.get(clone.keyAt(i2));
                    if (list != null) {
                        for (c.p.a.e.b.n.a aVar : list) {
                            try {
                                this.m.a(com.ss.android.socialbase.downloader.i.g.G(aVar));
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                c.p.a.e.b.c.a.d(p, "resumePendingTaskForIndependent failed", th);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, componentName) == null) {
            this.m = null;
            c.p.a.e.b.g.o oVar = this.n;
            if (oVar != null) {
                oVar.i();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, componentName, iBinder) == null) {
            c.p.a.e.b.c.a.g(p, "onServiceConnected ");
            this.m = i.a.a(iBinder);
            c.p.a.e.b.g.o oVar = this.n;
            if (oVar != null) {
                oVar.a(iBinder);
            }
            String str = p;
            StringBuilder sb = new StringBuilder();
            sb.append("onServiceConnected aidlService!=null");
            sb.append(this.m != null);
            sb.append(" pendingTasks.size:");
            sb.append(this.f35100f.size());
            c.p.a.e.b.c.a.g(str, sb.toString());
            if (this.m != null) {
                c.p.a.e.b.g.f.c().p();
                this.f35101g = true;
                this.f35103i = false;
                int i2 = this.o;
                if (i2 != -1) {
                    try {
                        this.m.l(i2);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                }
                if (this.m != null) {
                    i();
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, componentName) == null) {
            c.p.a.e.b.c.a.g(p, "onServiceDisconnected ");
            this.m = null;
            this.f35101g = false;
            c.p.a.e.b.g.o oVar = this.n;
            if (oVar != null) {
                oVar.i();
            }
        }
    }

    @Override // c.p.a.e.b.g.c, c.p.a.e.b.g.p
    public void a(c.p.a.e.b.n.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
            return;
        }
        String str = p;
        StringBuilder sb = new StringBuilder();
        sb.append("tryDownload aidlService == null:");
        sb.append(this.m == null);
        c.p.a.e.b.c.a.g(str, sb.toString());
        if (this.m == null) {
            f(aVar);
            e(c.p.a.e.b.g.e.n(), this);
            return;
        }
        i();
        try {
            this.m.a(com.ss.android.socialbase.downloader.i.g.G(aVar));
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // c.p.a.e.b.g.c, c.p.a.e.b.g.p
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            com.ss.android.socialbase.downloader.downloader.i iVar = this.m;
            if (iVar == null) {
                this.o = i2;
                return;
            }
            try {
                iVar.l(i2);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }
}
