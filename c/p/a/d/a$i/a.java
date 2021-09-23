package c.p.a.d.a$i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import c.p.a.d.b.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.b.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: j  reason: collision with root package name */
    public static String f34570j = "";
    public static String k = "";
    public static String l = "";
    public static volatile a m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f34571a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f34572b;

    /* renamed from: c  reason: collision with root package name */
    public Context f34573c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Pair<com.ss.android.downloadlib.a.b.b, d>> f34574d;

    /* renamed from: e  reason: collision with root package name */
    public c f34575e;

    /* renamed from: f  reason: collision with root package name */
    public final List<b> f34576f;

    /* renamed from: g  reason: collision with root package name */
    public final ServiceConnection f34577g;

    /* renamed from: h  reason: collision with root package name */
    public String f34578h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f34579i;

    /* renamed from: c.p.a.d.a$i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class ServiceConnectionC1520a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f34580e;

        public ServiceConnectionC1520a(a aVar) {
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
            this.f34580e = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                synchronized (this.f34580e.f34579i) {
                    this.f34580e.d(false);
                    this.f34580e.f34575e = c.a.a(iBinder);
                    this.f34580e.g();
                    for (b bVar : this.f34580e.f34576f) {
                        bVar.a();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                synchronized (this.f34580e.f34579i) {
                    this.f34580e.d(false);
                    this.f34580e.f34575e = null;
                    for (b bVar : this.f34580e.f34576f) {
                        bVar.b();
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1039949875, "Lc/p/a/d/a$i/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1039949875, "Lc/p/a/d/a$i/a;");
        }
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
        this.f34571a = false;
        this.f34572b = false;
        this.f34574d = new ArrayList();
        this.f34576f = new ArrayList();
        this.f34577g = new ServiceConnectionC1520a(this);
        this.f34578h = "";
        this.f34579i = new Object();
    }

    public static a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (m == null) {
                synchronized (a.class) {
                    if (m == null) {
                        m = new a();
                    }
                }
            }
            return m;
        }
        return (a) invokeV.objValue;
    }

    public Intent a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            Intent intent = new Intent();
            intent.setAction(f34570j);
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
            if (queryIntentServices == null || queryIntentServices.size() != 1) {
                return null;
            }
            for (ResolveInfo resolveInfo : queryIntentServices) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (k.equals(str)) {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    return intent2;
                }
            }
            return null;
        }
        return (Intent) invokeL.objValue;
    }

    public void c(com.ss.android.downloadlib.a.b.b bVar, d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, dVar) == null) {
            synchronized (this.f34579i) {
                bVar.f75969e = l;
                if (TextUtils.isEmpty(bVar.f75970f)) {
                    bVar.f75970f = this.f34578h;
                }
                if (this.f34575e != null) {
                    try {
                        this.f34575e.a(bVar, dVar);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } else if (h() || e(this.f34573c, this.f34571a)) {
                    this.f34574d.add(Pair.create(bVar, dVar));
                }
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f34572b = z;
        }
    }

    public boolean e(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, context, z)) == null) {
            if (TextUtils.isEmpty(f34570j)) {
                JSONObject v = l.v();
                String optString = v.optString("s");
                f34570j = c.p.a.e.a.h.d.b(v.optString(IAdRequestParam.COST_NAME), optString);
                k = c.p.a.e.a.h.d.b(v.optString("u"), optString);
                l = c.p.a.e.a.h.d.b(v.optString("w"), optString);
            }
            this.f34571a = z;
            if (context != null) {
                this.f34573c = context.getApplicationContext();
                if (TextUtils.isEmpty(l)) {
                    l = this.f34573c.getPackageName();
                }
                if (this.f34575e != null || h()) {
                    return true;
                }
                return this.f34573c.bindService(a(context), this.f34577g, 33);
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f34575e != null) {
                this.f34573c.unbindService(this.f34577g);
                this.f34575e = null;
            }
            this.f34576f.clear();
            this.f34574d.clear();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (Pair<com.ss.android.downloadlib.a.b.b, d> pair : this.f34574d) {
                try {
                    this.f34575e.a((com.ss.android.downloadlib.a.b.b) pair.first, (d) pair.second);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            this.f34574d.clear();
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34572b : invokeV.booleanValue;
    }
}
