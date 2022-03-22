package c.a.n0.a.h2.l.c;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.system.wifi.listener.SwanWifiBroadcastReceiver;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public abstract class a implements c.a.n0.a.h2.l.c.b, c.a.n0.a.h2.l.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public WifiManager f4781b;

    /* renamed from: c  reason: collision with root package name */
    public SwanWifiBroadcastReceiver f4782c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.n0.a.h2.l.c.c f4783d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4784e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List<c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>>> f4785f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.n0.a.h2.l.b.b f4786g;

    /* renamed from: c.a.n0.a.h2.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0309a implements c.a.n0.a.h2.l.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0309a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.n0.a.h2.l.b.b
        public void a(WifiInfo wifiInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                if (wifiInfo == null) {
                    wifiInfo = this.a.f4781b.getConnectionInfo();
                }
                this.a.m(wifiInfo);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.n0.a.p2.g1.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f4787b;

        public b(a aVar, c.a.n0.a.p2.g1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4787b = aVar;
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WifiInfo wifiInfo = null;
                if (!this.f4787b.f4784e) {
                    this.f4787b.g(w0.X3, "not init", null, this.a);
                } else if (!this.f4787b.f4781b.isWifiEnabled()) {
                    this.f4787b.g(12005, "wifi is not on", null, this.a);
                } else if (!q0.K(this.f4787b.a)) {
                    this.f4787b.g(12006, "LBS is not on", null, this.a);
                } else if (ContextCompat.checkSelfPermission(this.f4787b.a, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    this.f4787b.g(12012, "no location permission", null, this.a);
                } else {
                    WifiInfo connectionInfo = this.f4787b.f4781b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    a aVar = this.f4787b;
                    aVar.g(0, "success", new c.a.n0.a.h2.l.d.b(wifiInfo, c.a.n0.a.h2.l.e.b.a(c.a.n0.a.h2.l.e.a.b(aVar.a, aVar.f4781b, wifiInfo))), this.a);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.a.h2.l.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>>> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4788b;

        /* renamed from: c  reason: collision with root package name */
        public List<c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<Void>>> f4789c;

        /* renamed from: d  reason: collision with root package name */
        public Lock f4790d;

        /* renamed from: e  reason: collision with root package name */
        public Handler f4791e;

        /* renamed from: f  reason: collision with root package name */
        public List<ScanResult> f4792f;

        /* renamed from: g  reason: collision with root package name */
        public Runnable f4793g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.n0.a.h2.l.b.c f4794h;
        public final /* synthetic */ a i;

        /* renamed from: c.a.n0.a.h2.l.c.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0310a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public RunnableC0310a(c cVar) {
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

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.f4790d.lock();
                    try {
                        if (this.a.f4788b) {
                            this.a.m(this.a.f4792f);
                            this.a.f4788b = false;
                        }
                    } finally {
                        this.a.f4790d.unlock();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements c.a.n0.a.h2.l.b.c {
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

            @Override // c.a.n0.a.h2.l.b.c
            public void a(List<ScanResult> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.f4792f = list;
                    this.a.f4790d.lock();
                    try {
                        if (this.a.f4788b) {
                            this.a.f4791e.removeCallbacks(this.a.f4793g);
                            this.a.m(list);
                            this.a.f4788b = false;
                        }
                    } finally {
                        this.a.f4790d.unlock();
                    }
                }
            }
        }

        /* renamed from: c.a.n0.a.h2.l.c.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0311c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.p2.g1.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c f4795b;

            public RunnableC0311c(c cVar, c.a.n0.a.p2.g1.c cVar2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, cVar2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4795b = cVar;
                this.a = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.f4795b.i.f4784e) {
                        this.f4795b.i.g(w0.X3, "not init", null, this.a);
                    } else if (!this.f4795b.i.f4781b.isWifiEnabled()) {
                        this.f4795b.i.g(12005, "wifi is not on", null, this.a);
                    } else if (!q0.K(this.f4795b.i.a)) {
                        this.f4795b.i.g(12006, "LBS is not on", null, this.a);
                    } else if (ContextCompat.checkSelfPermission(this.f4795b.i.a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        this.f4795b.f4790d.lock();
                        try {
                            if (this.f4795b.f4788b) {
                                this.f4795b.f4789c.add(this.a);
                                return;
                            }
                            this.f4795b.f4788b = true;
                            this.f4795b.f4790d.unlock();
                            this.f4795b.f4791e.postDelayed(this.f4795b.f4793g, 6000L);
                            this.f4795b.i.f4781b.startScan();
                            this.f4795b.i.g(0, "success", null, this.a);
                        } finally {
                            this.f4795b.f4790d.unlock();
                        }
                    } else {
                        this.f4795b.i.g(12012, "no location permission", null, this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = aVar;
            this.a = new CopyOnWriteArrayList();
            this.f4788b = false;
            this.f4789c = new CopyOnWriteArrayList();
            this.f4790d = new ReentrantLock();
            this.f4791e = new Handler(Looper.getMainLooper());
            this.f4793g = new RunnableC0310a(this);
            b bVar = new b(this);
            this.f4794h = bVar;
            aVar.f4782c.setScanListener(bVar);
        }

        @Override // c.a.n0.a.h2.l.c.c
        public boolean b(c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>>> list = this.a;
                if (list.contains(cVar)) {
                    return list.remove(cVar);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.n0.a.h2.l.c.c
        public void c(c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<Void>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
                return;
            }
            q.k(new RunnableC0311c(this, cVar), "wifiScan");
        }

        @Override // c.a.n0.a.h2.l.c.c
        public boolean d(c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>>> list = this.a;
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
                        arrayList.add(new c.a.n0.a.h2.l.d.b(scanResult));
                    }
                }
                List<c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>>> list2 = this.a;
                for (c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>> cVar : list2) {
                    this.i.g(0, "success", arrayList, cVar);
                }
                List<c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<Void>>> list3 = this.f4789c;
                this.f4789c = new CopyOnWriteArrayList();
                for (c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<Void>> cVar2 : list3) {
                    this.i.g(0, "success", null, cVar2);
                    for (c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>> cVar3 : list2) {
                        this.i.g(0, "success", arrayList, cVar3);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4784e = false;
        this.f4785f = new CopyOnWriteArrayList();
        this.f4786g = new C0309a(this);
        this.a = context;
        this.f4781b = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        SwanWifiBroadcastReceiver swanWifiBroadcastReceiver = new SwanWifiBroadcastReceiver(this.f4781b);
        this.f4782c = swanWifiBroadcastReceiver;
        swanWifiBroadcastReceiver.setConnectSuccessListener(this.f4786g);
        this.f4783d = new c(this);
    }

    @Override // c.a.n0.a.h2.l.c.c
    public boolean b(c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? this.f4783d.b(cVar) : invokeL.booleanValue;
    }

    @Override // c.a.n0.a.h2.l.c.c
    public void c(c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f4783d.c(cVar);
        }
    }

    @Override // c.a.n0.a.h2.l.c.c
    public boolean d(c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<List<c.a.n0.a.h2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? this.f4783d.d(cVar) : invokeL.booleanValue;
    }

    public <ResultType> void g(int i, String str, ResultType resulttype, c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<ResultType>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), str, resulttype, cVar}) == null) || cVar == null) {
            return;
        }
        c.a.n0.a.h2.l.d.c<ResultType> cVar2 = new c.a.n0.a.h2.l.d.c<>();
        cVar2.a = i;
        cVar2.f4814b = str;
        cVar2.f4815c = resulttype;
        cVar.onCallback(cVar2);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f4782c.unregisterSelf(this.a);
            this.f4785f = new CopyOnWriteArrayList();
            ((c) this.f4783d).n();
            o(false);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f4782c.unregisterSelf(this.a);
            o(false);
        }
    }

    public void j(c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || cVar == null) {
            return;
        }
        q.k(new b(this, cVar), "getConnectedWifi");
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f4782c.registerSelf(this.a);
            o(true);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f4784e : invokeV.booleanValue;
    }

    public final void m(WifiInfo wifiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wifiInfo) == null) {
            for (c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> cVar : this.f4785f) {
                g(0, "success", new c.a.n0.a.h2.l.d.b(wifiInfo, c.a.n0.a.h2.l.e.b.a(c.a.n0.a.h2.l.e.a.b(this.a, this.f4781b, wifiInfo))), cVar);
            }
        }
    }

    public boolean n(c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>>> list = this.f4785f;
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
            this.f4784e = z;
        }
    }

    public void p(c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            if (this.f4784e) {
                g(0, "success", null, cVar);
                return;
            }
            k();
            g(0, "success", null, cVar);
        }
    }

    public void q(c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            if (!this.f4784e) {
                g(0, "success", null, cVar);
                return;
            }
            i();
            g(0, "success", null, cVar);
        }
    }

    public boolean r(c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>>> list = this.f4785f;
            if (list.contains(cVar)) {
                return list.remove(cVar);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
