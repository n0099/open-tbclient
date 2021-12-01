package c.a.p0.a.r2.l.c;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.z2.q;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.system.wifi.listener.SwanWifiBroadcastReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public abstract class a implements c.a.p0.a.r2.l.c.b, c.a.p0.a.r2.l.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public WifiManager f7840b;

    /* renamed from: c  reason: collision with root package name */
    public SwanWifiBroadcastReceiver f7841c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.p0.a.r2.l.c.c f7842d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f7843e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List<c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>>> f7844f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.p0.a.r2.l.b.b f7845g;

    /* renamed from: c.a.p0.a.r2.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0451a implements c.a.p0.a.r2.l.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0451a(a aVar) {
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
            this.a = aVar;
        }

        @Override // c.a.p0.a.r2.l.b.b
        public void a(WifiInfo wifiInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                if (wifiInfo == null) {
                    wifiInfo = this.a.f7840b.getConnectionInfo();
                }
                this.a.m(wifiInfo);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.a.z2.g1.c f7846e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f7847f;

        public b(a aVar, c.a.p0.a.z2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7847f = aVar;
            this.f7846e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WifiInfo wifiInfo = null;
                if (!this.f7847f.f7843e) {
                    this.f7847f.g(w0.X3, "not init", null, this.f7846e);
                } else if (!this.f7847f.f7840b.isWifiEnabled()) {
                    this.f7847f.g(CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK, "wifi is not on", null, this.f7846e);
                } else if (!q0.K(this.f7847f.a)) {
                    this.f7847f.g(CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, "LBS is not on", null, this.f7846e);
                } else if (ContextCompat.checkSelfPermission(this.f7847f.a, s.f56842g) != 0) {
                    this.f7847f.g(12012, "no location permission", null, this.f7846e);
                } else {
                    WifiInfo connectionInfo = this.f7847f.f7840b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    a aVar = this.f7847f;
                    aVar.g(0, "success", new c.a.p0.a.r2.l.d.b(wifiInfo, c.a.p0.a.r2.l.e.b.a(c.a.p0.a.r2.l.e.a.b(aVar.a, aVar.f7840b, wifiInfo))), this.f7846e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.r2.l.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>>> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f7848b;

        /* renamed from: c  reason: collision with root package name */
        public List<c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<Void>>> f7849c;

        /* renamed from: d  reason: collision with root package name */
        public Lock f7850d;

        /* renamed from: e  reason: collision with root package name */
        public Handler f7851e;

        /* renamed from: f  reason: collision with root package name */
        public List<ScanResult> f7852f;

        /* renamed from: g  reason: collision with root package name */
        public Runnable f7853g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.p0.a.r2.l.b.c f7854h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f7855i;

        /* renamed from: c.a.p0.a.r2.l.c.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0452a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f7856e;

            public RunnableC0452a(c cVar) {
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
                this.f7856e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7856e.f7850d.lock();
                    try {
                        if (this.f7856e.f7848b) {
                            this.f7856e.m(this.f7856e.f7852f);
                            this.f7856e.f7848b = false;
                        }
                    } finally {
                        this.f7856e.f7850d.unlock();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements c.a.p0.a.r2.l.b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

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
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // c.a.p0.a.r2.l.b.c
            public void a(List<ScanResult> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.f7852f = list;
                    this.a.f7850d.lock();
                    try {
                        if (this.a.f7848b) {
                            this.a.f7851e.removeCallbacks(this.a.f7853g);
                            this.a.m(list);
                            this.a.f7848b = false;
                        }
                    } finally {
                        this.a.f7850d.unlock();
                    }
                }
            }
        }

        /* renamed from: c.a.p0.a.r2.l.c.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0453c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.z2.g1.c f7857e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f7858f;

            public RunnableC0453c(c cVar, c.a.p0.a.z2.g1.c cVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, cVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f7858f = cVar;
                this.f7857e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.f7858f.f7855i.f7843e) {
                        this.f7858f.f7855i.g(w0.X3, "not init", null, this.f7857e);
                    } else if (!this.f7858f.f7855i.f7840b.isWifiEnabled()) {
                        this.f7858f.f7855i.g(CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK, "wifi is not on", null, this.f7857e);
                    } else if (!q0.K(this.f7858f.f7855i.a)) {
                        this.f7858f.f7855i.g(CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, "LBS is not on", null, this.f7857e);
                    } else if (ContextCompat.checkSelfPermission(this.f7858f.f7855i.a, s.f56842g) == 0) {
                        this.f7858f.f7850d.lock();
                        try {
                            if (this.f7858f.f7848b) {
                                this.f7858f.f7849c.add(this.f7857e);
                                return;
                            }
                            this.f7858f.f7848b = true;
                            this.f7858f.f7850d.unlock();
                            this.f7858f.f7851e.postDelayed(this.f7858f.f7853g, 6000L);
                            this.f7858f.f7855i.f7840b.startScan();
                            this.f7858f.f7855i.g(0, "success", null, this.f7857e);
                        } finally {
                            this.f7858f.f7850d.unlock();
                        }
                    } else {
                        this.f7858f.f7855i.g(12012, "no location permission", null, this.f7857e);
                    }
                }
            }
        }

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
            this.f7855i = aVar;
            this.a = new CopyOnWriteArrayList();
            this.f7848b = false;
            this.f7849c = new CopyOnWriteArrayList();
            this.f7850d = new ReentrantLock();
            this.f7851e = new Handler(Looper.getMainLooper());
            this.f7853g = new RunnableC0452a(this);
            b bVar = new b(this);
            this.f7854h = bVar;
            aVar.f7841c.setScanListener(bVar);
        }

        @Override // c.a.p0.a.r2.l.c.c
        public boolean b(c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>>> list = this.a;
                if (list.contains(cVar)) {
                    return list.remove(cVar);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.p0.a.r2.l.c.c
        public void c(c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<Void>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
                return;
            }
            q.k(new RunnableC0453c(this, cVar), "wifiScan");
        }

        @Override // c.a.p0.a.r2.l.c.c
        public boolean d(c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>>> list = this.a;
                if (list.contains(cVar)) {
                    return true;
                }
                return list.add(cVar);
            }
            return invokeL.booleanValue;
        }

        public final void m(List<ScanResult> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, list) == null) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        arrayList.add(new c.a.p0.a.r2.l.d.b(scanResult));
                    }
                }
                List<c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>>> list2 = this.a;
                for (c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>> cVar : list2) {
                    this.f7855i.g(0, "success", arrayList, cVar);
                }
                List<c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<Void>>> list3 = this.f7849c;
                this.f7849c = new CopyOnWriteArrayList();
                for (c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<Void>> cVar2 : list3) {
                    this.f7855i.g(0, "success", null, cVar2);
                    for (c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>> cVar3 : list2) {
                        this.f7855i.g(0, "success", arrayList, cVar3);
                    }
                }
            }
        }

        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.a = new CopyOnWriteArrayList();
            }
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7843e = false;
        this.f7844f = new CopyOnWriteArrayList();
        this.f7845g = new C0451a(this);
        this.a = context;
        this.f7840b = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        SwanWifiBroadcastReceiver swanWifiBroadcastReceiver = new SwanWifiBroadcastReceiver(this.f7840b);
        this.f7841c = swanWifiBroadcastReceiver;
        swanWifiBroadcastReceiver.setConnectSuccessListener(this.f7845g);
        this.f7842d = new c(this);
    }

    @Override // c.a.p0.a.r2.l.c.c
    public boolean b(c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? this.f7842d.b(cVar) : invokeL.booleanValue;
    }

    @Override // c.a.p0.a.r2.l.c.c
    public void c(c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f7842d.c(cVar);
        }
    }

    @Override // c.a.p0.a.r2.l.c.c
    public boolean d(c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<List<c.a.p0.a.r2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? this.f7842d.d(cVar) : invokeL.booleanValue;
    }

    public <ResultType> void g(int i2, String str, ResultType resulttype, c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<ResultType>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, resulttype, cVar}) == null) || cVar == null) {
            return;
        }
        c.a.p0.a.r2.l.d.c<ResultType> cVar2 = new c.a.p0.a.r2.l.d.c<>();
        cVar2.a = i2;
        cVar2.f7880b = str;
        cVar2.f7881c = resulttype;
        cVar.onCallback(cVar2);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f7841c.unregisterSelf(this.a);
            this.f7844f = new CopyOnWriteArrayList();
            ((c) this.f7842d).n();
            o(false);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f7841c.unregisterSelf(this.a);
            o(false);
        }
    }

    public void j(c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || cVar == null) {
            return;
        }
        q.k(new b(this, cVar), "getConnectedWifi");
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f7841c.registerSelf(this.a);
            o(true);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f7843e : invokeV.booleanValue;
    }

    public final void m(WifiInfo wifiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wifiInfo) == null) {
            for (c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> cVar : this.f7844f) {
                g(0, "success", new c.a.p0.a.r2.l.d.b(wifiInfo, c.a.p0.a.r2.l.e.b.a(c.a.p0.a.r2.l.e.a.b(this.a, this.f7840b, wifiInfo))), cVar);
            }
        }
    }

    public boolean n(c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>>> list = this.f7844f;
            if (list.contains(cVar)) {
                return true;
            }
            return list.add(cVar);
        }
        return invokeL.booleanValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f7843e = z;
        }
    }

    public void p(c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            if (this.f7843e) {
                g(0, "success", null, cVar);
                return;
            }
            k();
            g(0, "success", null, cVar);
        }
    }

    public void q(c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            if (!this.f7843e) {
                g(0, "success", null, cVar);
                return;
            }
            i();
            g(0, "success", null, cVar);
        }
    }

    public boolean r(c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>>> list = this.f7844f;
            if (list.contains(cVar)) {
                return list.remove(cVar);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
