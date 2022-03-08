package c.a.p0.a.h2.l.c;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.p2.q;
import c.a.p0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
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
public abstract class a implements c.a.p0.a.h2.l.c.b, c.a.p0.a.h2.l.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public WifiManager f5659b;

    /* renamed from: c  reason: collision with root package name */
    public SwanWifiBroadcastReceiver f5660c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.p0.a.h2.l.c.c f5661d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5662e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List<c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>>> f5663f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.p0.a.h2.l.b.b f5664g;

    /* renamed from: c.a.p0.a.h2.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0321a implements c.a.p0.a.h2.l.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0321a(a aVar) {
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

        @Override // c.a.p0.a.h2.l.b.b
        public void a(WifiInfo wifiInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                if (wifiInfo == null) {
                    wifiInfo = this.a.f5659b.getConnectionInfo();
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
        public final /* synthetic */ c.a.p0.a.p2.g1.c f5665e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5666f;

        public b(a aVar, c.a.p0.a.p2.g1.c cVar) {
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
            this.f5666f = aVar;
            this.f5665e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WifiInfo wifiInfo = null;
                if (!this.f5666f.f5662e) {
                    this.f5666f.g(w0.X3, "not init", null, this.f5665e);
                } else if (!this.f5666f.f5659b.isWifiEnabled()) {
                    this.f5666f.g(12005, "wifi is not on", null, this.f5665e);
                } else if (!q0.K(this.f5666f.a)) {
                    this.f5666f.g(12006, "LBS is not on", null, this.f5665e);
                } else if (ContextCompat.checkSelfPermission(this.f5666f.a, s.f53808g) != 0) {
                    this.f5666f.g(12012, "no location permission", null, this.f5665e);
                } else {
                    WifiInfo connectionInfo = this.f5666f.f5659b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    a aVar = this.f5666f;
                    aVar.g(0, "success", new c.a.p0.a.h2.l.d.b(wifiInfo, c.a.p0.a.h2.l.e.b.a(c.a.p0.a.h2.l.e.a.b(aVar.a, aVar.f5659b, wifiInfo))), this.f5665e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.h2.l.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>>> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5667b;

        /* renamed from: c  reason: collision with root package name */
        public List<c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<Void>>> f5668c;

        /* renamed from: d  reason: collision with root package name */
        public Lock f5669d;

        /* renamed from: e  reason: collision with root package name */
        public Handler f5670e;

        /* renamed from: f  reason: collision with root package name */
        public List<ScanResult> f5671f;

        /* renamed from: g  reason: collision with root package name */
        public Runnable f5672g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.p0.a.h2.l.b.c f5673h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f5674i;

        /* renamed from: c.a.p0.a.h2.l.c.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0322a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f5675e;

            public RunnableC0322a(c cVar) {
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
                this.f5675e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5675e.f5669d.lock();
                    try {
                        if (this.f5675e.f5667b) {
                            this.f5675e.m(this.f5675e.f5671f);
                            this.f5675e.f5667b = false;
                        }
                    } finally {
                        this.f5675e.f5669d.unlock();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements c.a.p0.a.h2.l.b.c {
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

            @Override // c.a.p0.a.h2.l.b.c
            public void a(List<ScanResult> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.f5671f = list;
                    this.a.f5669d.lock();
                    try {
                        if (this.a.f5667b) {
                            this.a.f5670e.removeCallbacks(this.a.f5672g);
                            this.a.m(list);
                            this.a.f5667b = false;
                        }
                    } finally {
                        this.a.f5669d.unlock();
                    }
                }
            }
        }

        /* renamed from: c.a.p0.a.h2.l.c.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0323c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.p2.g1.c f5676e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f5677f;

            public RunnableC0323c(c cVar, c.a.p0.a.p2.g1.c cVar2) {
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
                this.f5677f = cVar;
                this.f5676e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.f5677f.f5674i.f5662e) {
                        this.f5677f.f5674i.g(w0.X3, "not init", null, this.f5676e);
                    } else if (!this.f5677f.f5674i.f5659b.isWifiEnabled()) {
                        this.f5677f.f5674i.g(12005, "wifi is not on", null, this.f5676e);
                    } else if (!q0.K(this.f5677f.f5674i.a)) {
                        this.f5677f.f5674i.g(12006, "LBS is not on", null, this.f5676e);
                    } else if (ContextCompat.checkSelfPermission(this.f5677f.f5674i.a, s.f53808g) == 0) {
                        this.f5677f.f5669d.lock();
                        try {
                            if (this.f5677f.f5667b) {
                                this.f5677f.f5668c.add(this.f5676e);
                                return;
                            }
                            this.f5677f.f5667b = true;
                            this.f5677f.f5669d.unlock();
                            this.f5677f.f5670e.postDelayed(this.f5677f.f5672g, 6000L);
                            this.f5677f.f5674i.f5659b.startScan();
                            this.f5677f.f5674i.g(0, "success", null, this.f5676e);
                        } finally {
                            this.f5677f.f5669d.unlock();
                        }
                    } else {
                        this.f5677f.f5674i.g(12012, "no location permission", null, this.f5676e);
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
            this.f5674i = aVar;
            this.a = new CopyOnWriteArrayList();
            this.f5667b = false;
            this.f5668c = new CopyOnWriteArrayList();
            this.f5669d = new ReentrantLock();
            this.f5670e = new Handler(Looper.getMainLooper());
            this.f5672g = new RunnableC0322a(this);
            b bVar = new b(this);
            this.f5673h = bVar;
            aVar.f5660c.setScanListener(bVar);
        }

        @Override // c.a.p0.a.h2.l.c.c
        public boolean b(c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>>> list = this.a;
                if (list.contains(cVar)) {
                    return list.remove(cVar);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.p0.a.h2.l.c.c
        public void c(c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<Void>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
                return;
            }
            q.k(new RunnableC0323c(this, cVar), "wifiScan");
        }

        @Override // c.a.p0.a.h2.l.c.c
        public boolean d(c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>>> list = this.a;
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
                        arrayList.add(new c.a.p0.a.h2.l.d.b(scanResult));
                    }
                }
                List<c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>>> list2 = this.a;
                for (c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>> cVar : list2) {
                    this.f5674i.g(0, "success", arrayList, cVar);
                }
                List<c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<Void>>> list3 = this.f5668c;
                this.f5668c = new CopyOnWriteArrayList();
                for (c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<Void>> cVar2 : list3) {
                    this.f5674i.g(0, "success", null, cVar2);
                    for (c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>> cVar3 : list2) {
                        this.f5674i.g(0, "success", arrayList, cVar3);
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
        this.f5662e = false;
        this.f5663f = new CopyOnWriteArrayList();
        this.f5664g = new C0321a(this);
        this.a = context;
        this.f5659b = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        SwanWifiBroadcastReceiver swanWifiBroadcastReceiver = new SwanWifiBroadcastReceiver(this.f5659b);
        this.f5660c = swanWifiBroadcastReceiver;
        swanWifiBroadcastReceiver.setConnectSuccessListener(this.f5664g);
        this.f5661d = new c(this);
    }

    @Override // c.a.p0.a.h2.l.c.c
    public boolean b(c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? this.f5661d.b(cVar) : invokeL.booleanValue;
    }

    @Override // c.a.p0.a.h2.l.c.c
    public void c(c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f5661d.c(cVar);
        }
    }

    @Override // c.a.p0.a.h2.l.c.c
    public boolean d(c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<List<c.a.p0.a.h2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? this.f5661d.d(cVar) : invokeL.booleanValue;
    }

    public <ResultType> void g(int i2, String str, ResultType resulttype, c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<ResultType>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, resulttype, cVar}) == null) || cVar == null) {
            return;
        }
        c.a.p0.a.h2.l.d.c<ResultType> cVar2 = new c.a.p0.a.h2.l.d.c<>();
        cVar2.a = i2;
        cVar2.f5699b = str;
        cVar2.f5700c = resulttype;
        cVar.onCallback(cVar2);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f5660c.unregisterSelf(this.a);
            this.f5663f = new CopyOnWriteArrayList();
            ((c) this.f5661d).n();
            o(false);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f5660c.unregisterSelf(this.a);
            o(false);
        }
    }

    public void j(c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || cVar == null) {
            return;
        }
        q.k(new b(this, cVar), "getConnectedWifi");
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f5660c.registerSelf(this.a);
            o(true);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5662e : invokeV.booleanValue;
    }

    public final void m(WifiInfo wifiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wifiInfo) == null) {
            for (c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> cVar : this.f5663f) {
                g(0, "success", new c.a.p0.a.h2.l.d.b(wifiInfo, c.a.p0.a.h2.l.e.b.a(c.a.p0.a.h2.l.e.a.b(this.a, this.f5659b, wifiInfo))), cVar);
            }
        }
    }

    public boolean n(c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>>> list = this.f5663f;
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
            this.f5662e = z;
        }
    }

    public void p(c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            if (this.f5662e) {
                g(0, "success", null, cVar);
                return;
            }
            k();
            g(0, "success", null, cVar);
        }
    }

    public void q(c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            if (!this.f5662e) {
                g(0, "success", null, cVar);
                return;
            }
            i();
            g(0, "success", null, cVar);
        }
    }

    public boolean r(c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>>> list = this.f5663f;
            if (list.contains(cVar)) {
                return list.remove(cVar);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
