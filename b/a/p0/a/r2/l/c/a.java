package b.a.p0.a.r2.l.c;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.swan.apps.system.wifi.listener.SwanWifiBroadcastReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public abstract class a implements b.a.p0.a.r2.l.c.b, b.a.p0.a.r2.l.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f8235a;

    /* renamed from: b  reason: collision with root package name */
    public WifiManager f8236b;

    /* renamed from: c  reason: collision with root package name */
    public SwanWifiBroadcastReceiver f8237c;

    /* renamed from: d  reason: collision with root package name */
    public final b.a.p0.a.r2.l.c.c f8238d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8239e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List<b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>>> f8240f;

    /* renamed from: g  reason: collision with root package name */
    public final b.a.p0.a.r2.l.b.b f8241g;

    /* renamed from: b.a.p0.a.r2.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0395a implements b.a.p0.a.r2.l.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f8242a;

        public C0395a(a aVar) {
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
            this.f8242a = aVar;
        }

        @Override // b.a.p0.a.r2.l.b.b
        public void a(WifiInfo wifiInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                if (wifiInfo == null) {
                    wifiInfo = this.f8242a.f8236b.getConnectionInfo();
                }
                this.f8242a.m(wifiInfo);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.p0.a.z2.g1.c f8243e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8244f;

        public b(a aVar, b.a.p0.a.z2.g1.c cVar) {
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
            this.f8244f = aVar;
            this.f8243e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WifiInfo wifiInfo = null;
                if (!this.f8244f.f8239e) {
                    this.f8244f.g(12000, "not init", null, this.f8243e);
                } else if (!this.f8244f.f8236b.isWifiEnabled()) {
                    this.f8244f.g(CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK, "wifi is not on", null, this.f8243e);
                } else if (!q0.K(this.f8244f.f8235a)) {
                    this.f8244f.g(CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, "LBS is not on", null, this.f8243e);
                } else if (ContextCompat.checkSelfPermission(this.f8244f.f8235a, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    this.f8244f.g(12012, "no location permission", null, this.f8243e);
                } else {
                    WifiInfo connectionInfo = this.f8244f.f8236b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    a aVar = this.f8244f;
                    aVar.g(0, "success", new b.a.p0.a.r2.l.d.b(wifiInfo, b.a.p0.a.r2.l.e.b.a(b.a.p0.a.r2.l.e.a.b(aVar.f8235a, aVar.f8236b, wifiInfo))), this.f8243e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.r2.l.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public volatile List<b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>>> f8245a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8246b;

        /* renamed from: c  reason: collision with root package name */
        public List<b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<Void>>> f8247c;

        /* renamed from: d  reason: collision with root package name */
        public Lock f8248d;

        /* renamed from: e  reason: collision with root package name */
        public Handler f8249e;

        /* renamed from: f  reason: collision with root package name */
        public List<ScanResult> f8250f;

        /* renamed from: g  reason: collision with root package name */
        public Runnable f8251g;

        /* renamed from: h  reason: collision with root package name */
        public b.a.p0.a.r2.l.b.c f8252h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f8253i;

        /* renamed from: b.a.p0.a.r2.l.c.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0396a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f8254e;

            public RunnableC0396a(c cVar) {
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
                this.f8254e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8254e.f8248d.lock();
                    try {
                        if (this.f8254e.f8246b) {
                            this.f8254e.m(this.f8254e.f8250f);
                            this.f8254e.f8246b = false;
                        }
                    } finally {
                        this.f8254e.f8248d.unlock();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements b.a.p0.a.r2.l.b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f8255a;

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
                this.f8255a = cVar;
            }

            @Override // b.a.p0.a.r2.l.b.c
            public void a(List<ScanResult> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.f8255a.f8250f = list;
                    this.f8255a.f8248d.lock();
                    try {
                        if (this.f8255a.f8246b) {
                            this.f8255a.f8249e.removeCallbacks(this.f8255a.f8251g);
                            this.f8255a.m(list);
                            this.f8255a.f8246b = false;
                        }
                    } finally {
                        this.f8255a.f8248d.unlock();
                    }
                }
            }
        }

        /* renamed from: b.a.p0.a.r2.l.c.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0397c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.z2.g1.c f8256e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f8257f;

            public RunnableC0397c(c cVar, b.a.p0.a.z2.g1.c cVar2) {
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
                this.f8257f = cVar;
                this.f8256e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.f8257f.f8253i.f8239e) {
                        this.f8257f.f8253i.g(12000, "not init", null, this.f8256e);
                    } else if (!this.f8257f.f8253i.f8236b.isWifiEnabled()) {
                        this.f8257f.f8253i.g(CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK, "wifi is not on", null, this.f8256e);
                    } else if (!q0.K(this.f8257f.f8253i.f8235a)) {
                        this.f8257f.f8253i.g(CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, "LBS is not on", null, this.f8256e);
                    } else if (ContextCompat.checkSelfPermission(this.f8257f.f8253i.f8235a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        this.f8257f.f8248d.lock();
                        try {
                            if (this.f8257f.f8246b) {
                                this.f8257f.f8247c.add(this.f8256e);
                                return;
                            }
                            this.f8257f.f8246b = true;
                            this.f8257f.f8248d.unlock();
                            this.f8257f.f8249e.postDelayed(this.f8257f.f8251g, 6000L);
                            this.f8257f.f8253i.f8236b.startScan();
                            this.f8257f.f8253i.g(0, "success", null, this.f8256e);
                        } finally {
                            this.f8257f.f8248d.unlock();
                        }
                    } else {
                        this.f8257f.f8253i.g(12012, "no location permission", null, this.f8256e);
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
            this.f8253i = aVar;
            this.f8245a = new CopyOnWriteArrayList();
            this.f8246b = false;
            this.f8247c = new CopyOnWriteArrayList();
            this.f8248d = new ReentrantLock();
            this.f8249e = new Handler(Looper.getMainLooper());
            this.f8251g = new RunnableC0396a(this);
            b bVar = new b(this);
            this.f8252h = bVar;
            aVar.f8237c.setScanListener(bVar);
        }

        @Override // b.a.p0.a.r2.l.c.c
        public boolean b(b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>>> list = this.f8245a;
                if (list.contains(cVar)) {
                    return list.remove(cVar);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // b.a.p0.a.r2.l.c.c
        public void c(b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<Void>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
                return;
            }
            q.k(new RunnableC0397c(this, cVar), "wifiScan");
        }

        @Override // b.a.p0.a.r2.l.c.c
        public boolean d(b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>>> list = this.f8245a;
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
                        arrayList.add(new b.a.p0.a.r2.l.d.b(scanResult));
                    }
                }
                List<b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>>> list2 = this.f8245a;
                for (b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>> cVar : list2) {
                    this.f8253i.g(0, "success", arrayList, cVar);
                }
                List<b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<Void>>> list3 = this.f8247c;
                this.f8247c = new CopyOnWriteArrayList();
                for (b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<Void>> cVar2 : list3) {
                    this.f8253i.g(0, "success", null, cVar2);
                    for (b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>> cVar3 : list2) {
                        this.f8253i.g(0, "success", arrayList, cVar3);
                    }
                }
            }
        }

        public void n() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f8245a = new CopyOnWriteArrayList();
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
        this.f8239e = false;
        this.f8240f = new CopyOnWriteArrayList();
        this.f8241g = new C0395a(this);
        this.f8235a = context;
        this.f8236b = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        SwanWifiBroadcastReceiver swanWifiBroadcastReceiver = new SwanWifiBroadcastReceiver(this.f8236b);
        this.f8237c = swanWifiBroadcastReceiver;
        swanWifiBroadcastReceiver.setConnectSuccessListener(this.f8241g);
        this.f8238d = new c(this);
    }

    @Override // b.a.p0.a.r2.l.c.c
    public boolean b(b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? this.f8238d.b(cVar) : invokeL.booleanValue;
    }

    @Override // b.a.p0.a.r2.l.c.c
    public void c(b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f8238d.c(cVar);
        }
    }

    @Override // b.a.p0.a.r2.l.c.c
    public boolean d(b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<List<b.a.p0.a.r2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? this.f8238d.d(cVar) : invokeL.booleanValue;
    }

    public <ResultType> void g(int i2, String str, ResultType resulttype, b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<ResultType>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, resulttype, cVar}) == null) || cVar == null) {
            return;
        }
        b.a.p0.a.r2.l.d.c<ResultType> cVar2 = new b.a.p0.a.r2.l.d.c<>();
        cVar2.f8284a = i2;
        cVar2.f8285b = str;
        cVar2.f8286c = resulttype;
        cVar.onCallback(cVar2);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f8237c.unregisterSelf(this.f8235a);
            this.f8240f = new CopyOnWriteArrayList();
            ((c) this.f8238d).n();
            o(false);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f8237c.unregisterSelf(this.f8235a);
            o(false);
        }
    }

    public void j(b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || cVar == null) {
            return;
        }
        q.k(new b(this, cVar), "getConnectedWifi");
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f8237c.registerSelf(this.f8235a);
            o(true);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f8239e : invokeV.booleanValue;
    }

    public final void m(WifiInfo wifiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wifiInfo) == null) {
            for (b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> cVar : this.f8240f) {
                g(0, "success", new b.a.p0.a.r2.l.d.b(wifiInfo, b.a.p0.a.r2.l.e.b.a(b.a.p0.a.r2.l.e.a.b(this.f8235a, this.f8236b, wifiInfo))), cVar);
            }
        }
    }

    public boolean n(b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>>> list = this.f8240f;
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
            this.f8239e = z;
        }
    }

    public void p(b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            if (this.f8239e) {
                g(0, "success", null, cVar);
                return;
            }
            k();
            g(0, "success", null, cVar);
        }
    }

    public void q(b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            if (!this.f8239e) {
                g(0, "success", null, cVar);
                return;
            }
            i();
            g(0, "success", null, cVar);
        }
    }

    public boolean r(b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>>> list = this.f8240f;
            if (list.contains(cVar)) {
                return list.remove(cVar);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
