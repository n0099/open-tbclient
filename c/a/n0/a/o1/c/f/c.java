package c.a.n0.a.o1.c.f;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.t1.h;
import c.a.n0.a.t1.i;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.client.SwanAppLocalService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
/* loaded from: classes.dex */
public final class c extends c.a.n0.a.o1.c.b implements Object {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final SwanAppProcessInfo f5627b;

    /* renamed from: c  reason: collision with root package name */
    public String f5628c;

    /* renamed from: d  reason: collision with root package name */
    public Messenger f5629d;

    /* renamed from: e  reason: collision with root package name */
    public SwanAppCores f5630e;

    /* renamed from: f  reason: collision with root package name */
    public PrefetchEvent f5631f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f5632g;

    /* renamed from: h  reason: collision with root package name */
    public long f5633h;
    public boolean i;
    public ServiceConnectionC0402c j;
    public final Deque<Message> k;
    public b l;
    public final Set<String> m;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar);
    }

    /* renamed from: c.a.n0.a.o1.c.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ServiceConnectionC0402c implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public ServiceConnectionC0402c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                synchronized (this.a.f5627b) {
                    this.a.f5629d = new Messenger(iBinder);
                    e k = e.k();
                    k.m().a("event_puppet_online", this.a);
                    if (c.n) {
                        k.u("on main bind to swan: " + this.a.f5627b);
                    }
                    this.a.K();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.a.Z();
            }
        }

        public /* synthetic */ ServiceConnectionC0402c(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-618967707, "Lc/a/n0/a/o1/c/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-618967707, "Lc/a/n0/a/o1/c/f/c;");
                return;
            }
        }
        n = c.a.n0.a.o1.c.a.f5605b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(c.a.n0.a.t1.d.J());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppProcessInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f5628c = "";
        this.f5629d = null;
        this.f5632g = true;
        this.f5633h = 0L;
        this.i = false;
        this.k = new ArrayDeque();
        this.m = c.a.n0.a.p2.a1.a.a(new String[0]);
        this.f5627b = swanAppProcessInfo;
        c.a.n0.a.t1.b bVar = new c.a.n0.a.t1.b();
        bVar.e(this, "event_messenger_call");
        v(bVar);
    }

    private c update(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bundle)) == null) {
            Parcelable parcelable = bundle.getParcelable("app_core");
            o0(parcelable instanceof SwanAppCores ? (SwanAppCores) parcelable : null);
            String string = bundle.getString("app_id");
            if (!TextUtils.isEmpty(string)) {
                T(string);
                e.k().g(string, this);
                c.a.n0.a.o1.c.a.e().d(string);
                d0();
            }
            k0();
            return this;
        }
        return (c) invokeL.objValue;
    }

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f5628c) : invokeV.booleanValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.m) {
                this.m.clear();
                if (n) {
                    Log.d("SwanClientPuppet", "clear all prefetch ids");
                }
            }
        }
    }

    public c K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            U("flushCachedMsgs");
            synchronized (this.f5627b) {
                while (this.f5629d != null && !this.k.isEmpty()) {
                    Message peek = this.k.peek();
                    if (peek.replyTo == null) {
                        peek.replyTo = e.k().f5636d;
                    }
                    if (!g0(peek)) {
                        break;
                    }
                    this.k.poll();
                }
            }
            return this;
        }
        return (c) invokeV.objValue;
    }

    public Set<String> L() {
        InterceptResult invokeV;
        HashSet hashSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            synchronized (this.m) {
                hashSet = new HashSet(this.m);
                if (this.f5631f != null && !TextUtils.isEmpty(this.f5631f.appId)) {
                    hashSet.add(this.f5631f.appId);
                }
            }
            return hashSet;
        }
        return (Set) invokeV.objValue;
    }

    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            PrefetchEvent prefetchEvent = this.f5631f;
            return prefetchEvent != null ? prefetchEvent.appId : "";
        }
        return (String) invokeV.objValue;
    }

    public SwanAppProcessInfo N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5627b : (SwanAppProcessInfo) invokeV.objValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.f5627b) {
                z = this.f5629d != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f5631f != null : invokeV.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5632g : invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public boolean S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? O() : invokeV.booleanValue;
    }

    public c T(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            if (!TextUtils.equals(str, this.f5628c)) {
                if (TextUtils.isEmpty(str)) {
                    str = "swan_id_unknown";
                }
                this.f5628c = str;
                e.k().m().a("event_puppet_load_app", this);
                this.f5632g = true;
            } else {
                this.f5632g = false;
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final void U(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, str) == null) && n) {
            Log.i("SwanClientPuppet", str);
        }
    }

    public c V(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, bundle)) == null) ? update(bundle) : (c) invokeL.objValue;
    }

    public c W(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bundle)) == null) {
            i0(null);
            J();
            return update(bundle);
        }
        return (c) invokeL.objValue;
    }

    public c X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c0();
            e.k().m().a("event_puppet_unload_app", this);
            return this;
        }
        return (c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: Y */
    public void onCallback(i.a aVar) {
        String[] p;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) && c.a.n0.a.o1.b.d.I(aVar.D(), "swan_multi_preload_on_server") && aVar.i("swan_multi_preload_app_process_index") == this.f5627b.index && (p = aVar.p("swan_multi_preload_app_ids")) != null) {
            synchronized (this.m) {
                this.m.clear();
                for (String str : p) {
                    if (!TextUtils.isEmpty(str)) {
                        this.m.add(str);
                    }
                }
                if (n) {
                    Log.d("SwanClientPuppet", "get all in prefetch ids - " + this.m);
                }
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this.f5627b) {
                this.f5629d = null;
                this.j = null;
                b0();
                e k = e.k();
                k.m().a("event_puppet_offline", this);
                if (n) {
                    k.u("onSwanClientConnDown => " + this);
                }
                k.w();
            }
        }
    }

    public c a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            this.i = true;
            this.f5633h = 0L;
            b bVar = this.l;
            if (bVar != null) {
                bVar.a(this);
            }
            return this;
        }
        return (c) invokeV.objValue;
    }

    public c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            synchronized (this.f5627b) {
                c0();
                this.f5629d = null;
                this.f5630e = null;
                i0(null);
                J();
                d0();
            }
            return this;
        }
        return (c) invokeV.objValue;
    }

    public c c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            this.f5628c = "";
            i0(null);
            J();
            return this;
        }
        return (c) invokeV.objValue;
    }

    public c d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            this.i = false;
            this.f5633h = 0L;
            i0(null);
            J();
            return this;
        }
        return (c) invokeV.objValue;
    }

    public void e0(@NonNull Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, message) == null) {
            try {
                Application c2 = c.a.n0.a.s0.a.c();
                Intent intent = new Intent(c2, this.f5627b.service);
                intent.setAction(SwanAppLocalService.ACTION_RECEIVER_MSG);
                intent.putExtra("data", message);
                c2.startService(intent);
            } catch (Throwable th) {
                c.a.n0.a.u.d.d("SwanClientPuppet", "sendMessageToClientService fail", th);
            }
        }
    }

    public boolean f0(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, message)) == null) {
            this.k.offer(message);
            K();
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0021 A[Catch: all -> 0x0027, TryCatch #1 {, blocks: (B:7:0x0009, B:9:0x000f, B:11:0x0015, B:16:0x001a, B:18:0x0021, B:19:0x0024), top: B:29:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean g0(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, message)) == null) {
            synchronized (this.f5627b) {
                if (message != null) {
                    if (S()) {
                        try {
                            this.f5629d.send(message);
                            return true;
                        } catch (RemoteException e2) {
                            e = e2;
                            Z();
                            if (n) {
                                e.printStackTrace();
                            }
                            return false;
                        } catch (RuntimeException e3) {
                            e = e3;
                            Z();
                            if (n) {
                            }
                            return false;
                        }
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f5628c : (String) invokeV.objValue;
    }

    public boolean h0(Collection<Message> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, collection)) == null) {
            for (Message message : collection) {
                this.k.offer(message);
            }
            K();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void i0(PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, prefetchEvent) == null) {
            this.f5631f = prefetchEvent;
        }
    }

    public void j0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public c k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            l0(false, null, null);
            return this;
        }
        return (c) invokeV.objValue;
    }

    public c l0(boolean z, Context context, Bundle bundle) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Boolean.valueOf(z), context, bundle})) == null) {
            if (n) {
                e k = e.k();
                k.u("b4 tryPreBind: " + this.f5627b + " trace=" + Log.getStackTraceString(new Throwable()));
            }
            Application c2 = c.a.n0.a.s0.a.c();
            Intent intent = new Intent(c2, this.f5627b.service);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            this.f5633h = System.currentTimeMillis();
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            intent.putExtra("bundle_key_main_pid", Process.myPid());
            intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
            intent.addCategory("android.intent.category.DEFAULT");
            synchronized (this.f5627b) {
                try {
                    if (this.j == null) {
                        ServiceConnectionC0402c serviceConnectionC0402c = new ServiceConnectionC0402c(this, null);
                        this.j = serviceConnectionC0402c;
                        c2.bindService(intent, serviceConnectionC0402c, 1);
                    } else if (z) {
                        c2.startService(intent);
                    }
                } catch (Exception e2) {
                    if (n) {
                        e2.printStackTrace();
                    }
                }
                if (this.f5629d != null) {
                    K();
                }
            }
            return this;
        }
        return (c) invokeCommon.objValue;
    }

    public c m0(Context context, Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, context, bundle)) == null) {
            if (n) {
                e k = e.k();
                k.u("b4 preload: " + this.f5627b);
            }
            l0(true, context, bundle);
            return this;
        }
        return (c) invokeLL.objValue;
    }

    @Override // c.a.n0.a.t1.m, c.a.n0.a.t1.h
    public SwanAppCores n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f5630e : (SwanAppCores) invokeV.objValue;
    }

    public c n0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048609, this, j)) == null) {
            if (j > 0) {
                e.k().m().a("event_puppet_fmp_launch_finish", this);
            }
            return this;
        }
        return (c) invokeJ.objValue;
    }

    public c o0(SwanAppCores swanAppCores) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, swanAppCores)) == null) {
            if (swanAppCores != null) {
                this.f5630e = swanAppCores;
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return String.format(Locale.getDefault(), "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", this.f5627b.toString(), Integer.valueOf(S() ? 1 : 0), Integer.valueOf(this.i ? 1 : 0), SimpleDateFormat.getTimeInstance(2).format(new Date(this.f5633h)), this.f5628c);
        }
        return (String) invokeV.objValue;
    }
}
