package c.a.s0.a.r2.l.c;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.z2.q;
import c.a.s0.a.z2.q0;
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
public abstract class a implements c.a.s0.a.r2.l.c.b, c.a.s0.a.r2.l.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public WifiManager f8931b;

    /* renamed from: c  reason: collision with root package name */
    public SwanWifiBroadcastReceiver f8932c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.s0.a.r2.l.c.c f8933d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8934e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List<c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<c.a.s0.a.r2.l.d.b>>> f8935f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.s0.a.r2.l.b.b f8936g;

    /* renamed from: c.a.s0.a.r2.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0564a implements c.a.s0.a.r2.l.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0564a(a aVar) {
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

        @Override // c.a.s0.a.r2.l.b.b
        public void a(WifiInfo wifiInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                if (wifiInfo == null) {
                    wifiInfo = this.a.f8931b.getConnectionInfo();
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
        public final /* synthetic */ c.a.s0.a.z2.g1.c f8937e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8938f;

        public b(a aVar, c.a.s0.a.z2.g1.c cVar) {
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
            this.f8938f = aVar;
            this.f8937e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WifiInfo wifiInfo = null;
                if (!this.f8938f.f8934e) {
                    this.f8938f.g(w0.X3, "not init", null, this.f8937e);
                } else if (!this.f8938f.f8931b.isWifiEnabled()) {
                    this.f8938f.g(12005, "wifi is not on", null, this.f8937e);
                } else if (!q0.K(this.f8938f.a)) {
                    this.f8938f.g(12006, "LBS is not on", null, this.f8937e);
                } else if (ContextCompat.checkSelfPermission(this.f8938f.a, s.f55458g) != 0) {
                    this.f8938f.g(12012, "no location permission", null, this.f8937e);
                } else {
                    WifiInfo connectionInfo = this.f8938f.f8931b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    a aVar = this.f8938f;
                    aVar.g(0, "success", new c.a.s0.a.r2.l.d.b(wifiInfo, c.a.s0.a.r2.l.e.b.a(c.a.s0.a.r2.l.e.a.b(aVar.a, aVar.f8931b, wifiInfo))), this.f8937e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.s0.a.r2.l.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<List<c.a.s0.a.r2.l.d.b>>>> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8939b;

        /* renamed from: c  reason: collision with root package name */
        public List<c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<Void>>> f8940c;

        /* renamed from: d  reason: collision with root package name */
        public Lock f8941d;

        /* renamed from: e  reason: collision with root package name */
        public Handler f8942e;

        /* renamed from: f  reason: collision with root package name */
        public List<ScanResult> f8943f;

        /* renamed from: g  reason: collision with root package name */
        public Runnable f8944g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.s0.a.r2.l.b.c f8945h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f8946i;

        /* renamed from: c.a.s0.a.r2.l.c.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0565a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f8947e;

            public RunnableC0565a(c cVar) {
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
                this.f8947e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8947e.f8941d.lock();
                    try {
                        if (this.f8947e.f8939b) {
                            this.f8947e.m(this.f8947e.f8943f);
                            this.f8947e.f8939b = false;
                        }
                    } finally {
                        this.f8947e.f8941d.unlock();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements c.a.s0.a.r2.l.b.c {
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

            @Override // c.a.s0.a.r2.l.b.c
            public void a(List<ScanResult> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.f8943f = list;
                    this.a.f8941d.lock();
                    try {
                        if (this.a.f8939b) {
                            this.a.f8942e.removeCallbacks(this.a.f8944g);
                            this.a.m(list);
                            this.a.f8939b = false;
                        }
                    } finally {
                        this.a.f8941d.unlock();
                    }
                }
            }
        }

        /* renamed from: c.a.s0.a.r2.l.c.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0566c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.s0.a.z2.g1.c f8948e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f8949f;

            public RunnableC0566c(c cVar, c.a.s0.a.z2.g1.c cVar2) {
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
                this.f8949f = cVar;
                this.f8948e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.f8949f.f8946i.f8934e) {
                        this.f8949f.f8946i.g(w0.X3, "not init", null, this.f8948e);
                    } else if (!this.f8949f.f8946i.f8931b.isWifiEnabled()) {
                        this.f8949f.f8946i.g(12005, "wifi is not on", null, this.f8948e);
                    } else if (!q0.K(this.f8949f.f8946i.a)) {
                        this.f8949f.f8946i.g(12006, "LBS is not on", null, this.f8948e);
                    } else if (ContextCompat.checkSelfPermission(this.f8949f.f8946i.a, s.f55458g) == 0) {
                        this.f8949f.f8941d.lock();
                        try {
                            if (this.f8949f.f8939b) {
                                this.f8949f.f8940c.add(this.f8948e);
                                return;
                            }
                            this.f8949f.f8939b = true;
                            this.f8949f.f8941d.unlock();
                            this.f8949f.f8942e.postDelayed(this.f8949f.f8944g, 6000L);
                            this.f8949f.f8946i.f8931b.startScan();
                            this.f8949f.f8946i.g(0, "success", null, this.f8948e);
                        } finally {
                            this.f8949f.f8941d.unlock();
                        }
                    } else {
                        this.f8949f.f8946i.g(12012, "no location permission", null, this.f8948e);
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
            this.f8946i = aVar;
            this.a = new CopyOnWriteArrayList();
            this.f8939b = false;
            this.f8940c = new CopyOnWriteArrayList();
            this.f8941d = new ReentrantLock();
            this.f8942e = new Handler(Looper.getMainLooper());
            this.f8944g = new RunnableC0565a(this);
            b bVar = new b(this);
            this.f8945h = bVar;
            aVar.f8932c.setScanListener(bVar);
        }

        @Override // c.a.s0.a.r2.l.c.c
        public boolean b(c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<List<c.a.s0.a.r2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<List<c.a.s0.a.r2.l.d.b>>>> list = this.a;
                if (list.contains(cVar)) {
                    return list.remove(cVar);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.s0.a.r2.l.c.c
        public void c(c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<Void>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
                return;
            }
            q.k(new RunnableC0566c(this, cVar), "wifiScan");
        }

        @Override // c.a.s0.a.r2.l.c.c
        public boolean d(c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<List<c.a.s0.a.r2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<List<c.a.s0.a.r2.l.d.b>>>> list = this.a;
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
                        arrayList.add(new c.a.s0.a.r2.l.d.b(scanResult));
                    }
                }
                List<c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<List<c.a.s0.a.r2.l.d.b>>>> list2 = this.a;
                for (c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<List<c.a.s0.a.r2.l.d.b>>> cVar : list2) {
                    this.f8946i.g(0, "success", arrayList, cVar);
                }
                List<c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<Void>>> list3 = this.f8940c;
                this.f8940c = new CopyOnWriteArrayList();
                for (c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<Void>> cVar2 : list3) {
                    this.f8946i.g(0, "success", null, cVar2);
                    for (c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<List<c.a.s0.a.r2.l.d.b>>> cVar3 : list2) {
                        this.f8946i.g(0, "success", arrayList, cVar3);
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
        this.f8934e = false;
        this.f8935f = new CopyOnWriteArrayList();
        this.f8936g = new C0564a(this);
        this.a = context;
        this.f8931b = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        SwanWifiBroadcastReceiver swanWifiBroadcastReceiver = new SwanWifiBroadcastReceiver(this.f8931b);
        this.f8932c = swanWifiBroadcastReceiver;
        swanWifiBroadcastReceiver.setConnectSuccessListener(this.f8936g);
        this.f8933d = new c(this);
    }

    @Override // c.a.s0.a.r2.l.c.c
    public boolean b(c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<List<c.a.s0.a.r2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? this.f8933d.b(cVar) : invokeL.booleanValue;
    }

    @Override // c.a.s0.a.r2.l.c.c
    public void c(c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f8933d.c(cVar);
        }
    }

    @Override // c.a.s0.a.r2.l.c.c
    public boolean d(c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<List<c.a.s0.a.r2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? this.f8933d.d(cVar) : invokeL.booleanValue;
    }

    public <ResultType> void g(int i2, String str, ResultType resulttype, c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<ResultType>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, resulttype, cVar}) == null) || cVar == null) {
            return;
        }
        c.a.s0.a.r2.l.d.c<ResultType> cVar2 = new c.a.s0.a.r2.l.d.c<>();
        cVar2.a = i2;
        cVar2.f8971b = str;
        cVar2.f8972c = resulttype;
        cVar.onCallback(cVar2);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f8932c.unregisterSelf(this.a);
            this.f8935f = new CopyOnWriteArrayList();
            ((c) this.f8933d).n();
            o(false);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f8932c.unregisterSelf(this.a);
            o(false);
        }
    }

    public void j(c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<c.a.s0.a.r2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || cVar == null) {
            return;
        }
        q.k(new b(this, cVar), "getConnectedWifi");
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f8932c.registerSelf(this.a);
            o(true);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f8934e : invokeV.booleanValue;
    }

    public final void m(WifiInfo wifiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wifiInfo) == null) {
            for (c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<c.a.s0.a.r2.l.d.b>> cVar : this.f8935f) {
                g(0, "success", new c.a.s0.a.r2.l.d.b(wifiInfo, c.a.s0.a.r2.l.e.b.a(c.a.s0.a.r2.l.e.a.b(this.a, this.f8931b, wifiInfo))), cVar);
            }
        }
    }

    public boolean n(c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<c.a.s0.a.r2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<c.a.s0.a.r2.l.d.b>>> list = this.f8935f;
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
            this.f8934e = z;
        }
    }

    public void p(c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            if (this.f8934e) {
                g(0, "success", null, cVar);
                return;
            }
            k();
            g(0, "success", null, cVar);
        }
    }

    public void q(c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            if (!this.f8934e) {
                g(0, "success", null, cVar);
                return;
            }
            i();
            g(0, "success", null, cVar);
        }
    }

    public boolean r(c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<c.a.s0.a.r2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<c.a.s0.a.z2.g1.c<c.a.s0.a.r2.l.d.c<c.a.s0.a.r2.l.d.b>>> list = this.f8935f;
            if (list.contains(cVar)) {
                return list.remove(cVar);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
