package c.a.r0.a.y1.c.f;

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
import c.a.r0.a.d2.h;
import c.a.r0.a.d2.i;
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
public final class c extends c.a.r0.a.y1.c.b implements Object {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final SwanAppProcessInfo f9947f;

    /* renamed from: g  reason: collision with root package name */
    public String f9948g;

    /* renamed from: h  reason: collision with root package name */
    public Messenger f9949h;

    /* renamed from: i  reason: collision with root package name */
    public SwanAppCores f9950i;

    /* renamed from: j  reason: collision with root package name */
    public PrefetchEvent f9951j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f9952k;
    public long l;
    public boolean m;
    public ServiceConnectionC0628c n;
    public final Deque<Message> o;
    public b p;
    public final Set<String> q;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(c cVar);
    }

    /* renamed from: c.a.r0.a.y1.c.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ServiceConnectionC0628c implements ServiceConnection {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9953e;

        public ServiceConnectionC0628c(c cVar) {
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
            this.f9953e = cVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, componentName, iBinder) == null) {
                synchronized (this.f9953e.f9947f) {
                    this.f9953e.f9949h = new Messenger(iBinder);
                    e k2 = e.k();
                    k2.m().a("event_puppet_online", this.f9953e);
                    if (c.r) {
                        k2.u("on main bind to swan: " + this.f9953e.f9947f);
                    }
                    this.f9953e.K();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, componentName) == null) {
                this.f9953e.Z();
            }
        }

        public /* synthetic */ ServiceConnectionC0628c(c cVar, a aVar) {
            this(cVar);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(759089643, "Lc/a/r0/a/y1/c/f/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(759089643, "Lc/a/r0/a/y1/c/f/c;");
                return;
            }
        }
        r = c.a.r0.a.y1.c.a.f9923b;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SwanAppProcessInfo swanAppProcessInfo) {
        super(c.a.r0.a.d2.d.J());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppProcessInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((h) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f9948g = "";
        this.f9949h = null;
        this.f9952k = true;
        this.l = 0L;
        this.m = false;
        this.o = new ArrayDeque();
        this.q = c.a.r0.a.z2.a1.a.a(new String[0]);
        this.f9947f = swanAppProcessInfo;
        c.a.r0.a.d2.b bVar = new c.a.r0.a.d2.b();
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
                c.a.r0.a.y1.c.a.e().d(string);
                d0();
            }
            k0();
            return this;
        }
        return (c) invokeL.objValue;
    }

    @Override // c.a.r0.a.d2.m, c.a.r0.a.d2.h
    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? !TextUtils.isEmpty(this.f9948g) : invokeV.booleanValue;
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this.q) {
                this.q.clear();
                boolean z = r;
            }
        }
    }

    public c K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            U("flushCachedMsgs");
            synchronized (this.f9947f) {
                while (this.f9949h != null && !this.o.isEmpty()) {
                    Message peek = this.o.peek();
                    if (peek.replyTo == null) {
                        peek.replyTo = e.k().f9958d;
                    }
                    if (!g0(peek)) {
                        break;
                    }
                    this.o.poll();
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
            synchronized (this.q) {
                hashSet = new HashSet(this.q);
                if (this.f9951j != null && !TextUtils.isEmpty(this.f9951j.appId)) {
                    hashSet.add(this.f9951j.appId);
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
            PrefetchEvent prefetchEvent = this.f9951j;
            return prefetchEvent != null ? prefetchEvent.appId : "";
        }
        return (String) invokeV.objValue;
    }

    public SwanAppProcessInfo N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f9947f : (SwanAppProcessInfo) invokeV.objValue;
    }

    public boolean O() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this.f9947f) {
                z = this.f9949h != null;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f9951j != null : invokeV.booleanValue;
    }

    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f9952k : invokeV.booleanValue;
    }

    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : invokeV.booleanValue;
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
            if (!TextUtils.equals(str, this.f9948g)) {
                if (TextUtils.isEmpty(str)) {
                    str = "swan_id_unknown";
                }
                this.f9948g = str;
                e.k().m().a("event_puppet_load_app", this);
                this.f9952k = true;
            } else {
                this.f9952k = false;
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public final void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            boolean z = r;
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
        if ((interceptable == null || interceptable.invokeL(1048592, this, aVar) == null) && c.a.r0.a.y1.b.d.I(aVar.D(), "swan_multi_preload_on_server") && aVar.i("swan_multi_preload_app_process_index") == this.f9947f.index && (p = aVar.p("swan_multi_preload_app_ids")) != null) {
            synchronized (this.q) {
                this.q.clear();
                for (String str : p) {
                    if (!TextUtils.isEmpty(str)) {
                        this.q.add(str);
                    }
                }
                if (r) {
                    String str2 = "get all in prefetch ids - " + this.q;
                }
            }
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            synchronized (this.f9947f) {
                this.f9949h = null;
                this.n = null;
                b0();
                e k2 = e.k();
                k2.m().a("event_puppet_offline", this);
                if (r) {
                    k2.u("onSwanClientConnDown => " + this);
                }
                k2.w();
            }
        }
    }

    public c a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            this.m = true;
            this.l = 0L;
            b bVar = this.p;
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
            synchronized (this.f9947f) {
                c0();
                this.f9949h = null;
                this.f9950i = null;
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
            this.f9948g = "";
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
            this.m = false;
            this.l = 0L;
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
                Application c2 = c.a.r0.a.c1.a.c();
                Intent intent = new Intent(c2, this.f9947f.service);
                intent.setAction(SwanAppLocalService.ACTION_RECEIVER_MSG);
                intent.putExtra("data", message);
                c2.startService(intent);
            } catch (Throwable th) {
                c.a.r0.a.e0.d.d("SwanClientPuppet", "sendMessageToClientService fail", th);
            }
        }
    }

    public boolean f0(Message message) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, message)) == null) {
            this.o.offer(message);
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
            synchronized (this.f9947f) {
                if (message != null) {
                    if (S()) {
                        try {
                            this.f9949h.send(message);
                            return true;
                        } catch (RemoteException e2) {
                            e = e2;
                            Z();
                            if (r) {
                                e.printStackTrace();
                            }
                            return false;
                        } catch (RuntimeException e3) {
                            e = e3;
                            Z();
                            if (r) {
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

    @Override // c.a.r0.a.d2.m, c.a.r0.a.d2.h
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f9948g : (String) invokeV.objValue;
    }

    public boolean h0(Collection<Message> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, collection)) == null) {
            for (Message message : collection) {
                this.o.offer(message);
            }
            K();
            return true;
        }
        return invokeL.booleanValue;
    }

    public void i0(PrefetchEvent prefetchEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, prefetchEvent) == null) {
            this.f9951j = prefetchEvent;
        }
    }

    public void j0(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bVar) == null) {
            this.p = bVar;
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
            if (r) {
                e k2 = e.k();
                k2.u("b4 tryPreBind: " + this.f9947f + " trace=" + Log.getStackTraceString(new Throwable()));
            }
            Application c2 = c.a.r0.a.c1.a.c();
            Intent intent = new Intent(c2, this.f9947f.service);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            this.l = System.currentTimeMillis();
            intent.putExtra("call_preload_time", System.currentTimeMillis());
            intent.putExtra("bundle_key_main_pid", Process.myPid());
            intent.setAction(SwanAppLocalService.ACTION_PERLOAD);
            intent.addCategory("android.intent.category.DEFAULT");
            synchronized (this.f9947f) {
                try {
                    if (this.n == null) {
                        ServiceConnectionC0628c serviceConnectionC0628c = new ServiceConnectionC0628c(this, null);
                        this.n = serviceConnectionC0628c;
                        c2.bindService(intent, serviceConnectionC0628c, 1);
                    } else if (z) {
                        c2.startService(intent);
                    }
                } catch (Exception e2) {
                    if (r) {
                        e2.printStackTrace();
                    }
                }
                if (this.f9949h != null) {
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
            if (r) {
                e k2 = e.k();
                k2.u("b4 preload: " + this.f9947f);
            }
            l0(true, context, bundle);
            return this;
        }
        return (c) invokeLL.objValue;
    }

    @Override // c.a.r0.a.d2.m, c.a.r0.a.d2.h
    public SwanAppCores n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f9950i : (SwanAppCores) invokeV.objValue;
    }

    public c n0(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048609, this, j2)) == null) {
            if (j2 > 0) {
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
                this.f9950i = swanAppCores;
            }
            return this;
        }
        return (c) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return String.format(Locale.getDefault(), "%s: Connected=%d Preloaded=%d TryPreload=%s Loaded=%s", this.f9947f.toString(), Integer.valueOf(S() ? 1 : 0), Integer.valueOf(this.m ? 1 : 0), SimpleDateFormat.getTimeInstance(2).format(new Date(this.l)), this.f9948g);
        }
        return (String) invokeV.objValue;
    }
}
