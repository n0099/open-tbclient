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
    public static String f34574j = "";
    public static String k = "";
    public static String l = "";
    public static volatile a m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f34575a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f34576b;

    /* renamed from: c  reason: collision with root package name */
    public Context f34577c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Pair<com.ss.android.downloadlib.a.b.b, d>> f34578d;

    /* renamed from: e  reason: collision with root package name */
    public c f34579e;

    /* renamed from: f  reason: collision with root package name */
    public final List<b> f34580f;

    /* renamed from: g  reason: collision with root package name */
    public final ServiceConnection f34581g;

    /* renamed from: h  reason: collision with root package name */
    public String f34582h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f34583i;

    /* renamed from: c.p.a.d.a$i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class ServiceConnectionC1522a implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f34584e;

        public ServiceConnectionC1522a(a aVar) {
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
            this.f34584e = aVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                synchronized (this.f34584e.f34583i) {
                    this.f34584e.d(false);
                    this.f34584e.f34579e = c.a.a(iBinder);
                    this.f34584e.g();
                    for (b bVar : this.f34584e.f34580f) {
                        bVar.a();
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                synchronized (this.f34584e.f34583i) {
                    this.f34584e.d(false);
                    this.f34584e.f34579e = null;
                    for (b bVar : this.f34584e.f34580f) {
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
        this.f34575a = false;
        this.f34576b = false;
        this.f34578d = new ArrayList();
        this.f34580f = new ArrayList();
        this.f34581g = new ServiceConnectionC1522a(this);
        this.f34582h = "";
        this.f34583i = new Object();
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
            intent.setAction(f34574j);
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
            synchronized (this.f34583i) {
                bVar.f76004e = l;
                if (TextUtils.isEmpty(bVar.f76005f)) {
                    bVar.f76005f = this.f34582h;
                }
                if (this.f34579e != null) {
                    try {
                        this.f34579e.a(bVar, dVar);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                } else if (h() || e(this.f34577c, this.f34575a)) {
                    this.f34578d.add(Pair.create(bVar, dVar));
                }
            }
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.f34576b = z;
        }
    }

    public boolean e(Context context, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, context, z)) == null) {
            if (TextUtils.isEmpty(f34574j)) {
                JSONObject v = l.v();
                String optString = v.optString("s");
                f34574j = c.p.a.e.a.h.d.b(v.optString(IAdRequestParam.COST_NAME), optString);
                k = c.p.a.e.a.h.d.b(v.optString("u"), optString);
                l = c.p.a.e.a.h.d.b(v.optString("w"), optString);
            }
            this.f34575a = z;
            if (context != null) {
                this.f34577c = context.getApplicationContext();
                if (TextUtils.isEmpty(l)) {
                    l = this.f34577c.getPackageName();
                }
                if (this.f34579e != null || h()) {
                    return true;
                }
                return this.f34577c.bindService(a(context), this.f34581g, 33);
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f34579e != null) {
                this.f34577c.unbindService(this.f34581g);
                this.f34579e = null;
            }
            this.f34580f.clear();
            this.f34578d.clear();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            for (Pair<com.ss.android.downloadlib.a.b.b, d> pair : this.f34578d) {
                try {
                    this.f34579e.a((com.ss.android.downloadlib.a.b.b) pair.first, (d) pair.second);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            }
            this.f34578d.clear();
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f34576b : invokeV.booleanValue;
    }
}
