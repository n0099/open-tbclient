package c.a.r0.a.r2.l.c;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
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
public abstract class a implements c.a.r0.a.r2.l.c.b, c.a.r0.a.r2.l.c.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public WifiManager f8689b;

    /* renamed from: c  reason: collision with root package name */
    public SwanWifiBroadcastReceiver f8690c;

    /* renamed from: d  reason: collision with root package name */
    public final c.a.r0.a.r2.l.c.c f8691d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f8692e;

    /* renamed from: f  reason: collision with root package name */
    public volatile List<c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>>> f8693f;

    /* renamed from: g  reason: collision with root package name */
    public final c.a.r0.a.r2.l.b.b f8694g;

    /* renamed from: c.a.r0.a.r2.l.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0544a implements c.a.r0.a.r2.l.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0544a(a aVar) {
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

        @Override // c.a.r0.a.r2.l.b.b
        public void a(WifiInfo wifiInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                if (wifiInfo == null) {
                    wifiInfo = this.a.f8689b.getConnectionInfo();
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
        public final /* synthetic */ c.a.r0.a.z2.g1.c f8695e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f8696f;

        public b(a aVar, c.a.r0.a.z2.g1.c cVar) {
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
            this.f8696f = aVar;
            this.f8695e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                WifiInfo wifiInfo = null;
                if (!this.f8696f.f8692e) {
                    this.f8696f.g(w0.X3, "not init", null, this.f8695e);
                } else if (!this.f8696f.f8689b.isWifiEnabled()) {
                    this.f8696f.g(12005, "wifi is not on", null, this.f8695e);
                } else if (!q0.K(this.f8696f.a)) {
                    this.f8696f.g(12006, "LBS is not on", null, this.f8695e);
                } else if (ContextCompat.checkSelfPermission(this.f8696f.a, s.f55246g) != 0) {
                    this.f8696f.g(12012, "no location permission", null, this.f8695e);
                } else {
                    WifiInfo connectionInfo = this.f8696f.f8689b.getConnectionInfo();
                    if (connectionInfo == null || connectionInfo.getSupplicantState() == SupplicantState.COMPLETED) {
                        wifiInfo = connectionInfo;
                    }
                    a aVar = this.f8696f;
                    aVar.g(0, "success", new c.a.r0.a.r2.l.d.b(wifiInfo, c.a.r0.a.r2.l.e.b.a(c.a.r0.a.r2.l.e.a.b(aVar.a, aVar.f8689b, wifiInfo))), this.f8695e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.r0.a.r2.l.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public volatile List<c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>>> a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8697b;

        /* renamed from: c  reason: collision with root package name */
        public List<c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<Void>>> f8698c;

        /* renamed from: d  reason: collision with root package name */
        public Lock f8699d;

        /* renamed from: e  reason: collision with root package name */
        public Handler f8700e;

        /* renamed from: f  reason: collision with root package name */
        public List<ScanResult> f8701f;

        /* renamed from: g  reason: collision with root package name */
        public Runnable f8702g;

        /* renamed from: h  reason: collision with root package name */
        public c.a.r0.a.r2.l.b.c f8703h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f8704i;

        /* renamed from: c.a.r0.a.r2.l.c.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0545a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c f8705e;

            public RunnableC0545a(c cVar) {
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
                this.f8705e = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8705e.f8699d.lock();
                    try {
                        if (this.f8705e.f8697b) {
                            this.f8705e.m(this.f8705e.f8701f);
                            this.f8705e.f8697b = false;
                        }
                    } finally {
                        this.f8705e.f8699d.unlock();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements c.a.r0.a.r2.l.b.c {
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

            @Override // c.a.r0.a.r2.l.b.c
            public void a(List<ScanResult> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                    this.a.f8701f = list;
                    this.a.f8699d.lock();
                    try {
                        if (this.a.f8697b) {
                            this.a.f8700e.removeCallbacks(this.a.f8702g);
                            this.a.m(list);
                            this.a.f8697b = false;
                        }
                    } finally {
                        this.a.f8699d.unlock();
                    }
                }
            }
        }

        /* renamed from: c.a.r0.a.r2.l.c.a$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0546c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.z2.g1.c f8706e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c f8707f;

            public RunnableC0546c(c cVar, c.a.r0.a.z2.g1.c cVar2) {
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
                this.f8707f = cVar;
                this.f8706e = cVar2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!this.f8707f.f8704i.f8692e) {
                        this.f8707f.f8704i.g(w0.X3, "not init", null, this.f8706e);
                    } else if (!this.f8707f.f8704i.f8689b.isWifiEnabled()) {
                        this.f8707f.f8704i.g(12005, "wifi is not on", null, this.f8706e);
                    } else if (!q0.K(this.f8707f.f8704i.a)) {
                        this.f8707f.f8704i.g(12006, "LBS is not on", null, this.f8706e);
                    } else if (ContextCompat.checkSelfPermission(this.f8707f.f8704i.a, s.f55246g) == 0) {
                        this.f8707f.f8699d.lock();
                        try {
                            if (this.f8707f.f8697b) {
                                this.f8707f.f8698c.add(this.f8706e);
                                return;
                            }
                            this.f8707f.f8697b = true;
                            this.f8707f.f8699d.unlock();
                            this.f8707f.f8700e.postDelayed(this.f8707f.f8702g, 6000L);
                            this.f8707f.f8704i.f8689b.startScan();
                            this.f8707f.f8704i.g(0, "success", null, this.f8706e);
                        } finally {
                            this.f8707f.f8699d.unlock();
                        }
                    } else {
                        this.f8707f.f8704i.g(12012, "no location permission", null, this.f8706e);
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
            this.f8704i = aVar;
            this.a = new CopyOnWriteArrayList();
            this.f8697b = false;
            this.f8698c = new CopyOnWriteArrayList();
            this.f8699d = new ReentrantLock();
            this.f8700e = new Handler(Looper.getMainLooper());
            this.f8702g = new RunnableC0545a(this);
            b bVar = new b(this);
            this.f8703h = bVar;
            aVar.f8690c.setScanListener(bVar);
        }

        @Override // c.a.r0.a.r2.l.c.c
        public boolean b(c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>>> list = this.a;
                if (list.contains(cVar)) {
                    return list.remove(cVar);
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // c.a.r0.a.r2.l.c.c
        public void c(c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<Void>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
                return;
            }
            q.k(new RunnableC0546c(this, cVar), "wifiScan");
        }

        @Override // c.a.r0.a.r2.l.c.c
        public boolean d(c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>> cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) {
                if (cVar == null) {
                    return false;
                }
                List<c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>>> list = this.a;
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
                        arrayList.add(new c.a.r0.a.r2.l.d.b(scanResult));
                    }
                }
                List<c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>>> list2 = this.a;
                for (c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>> cVar : list2) {
                    this.f8704i.g(0, "success", arrayList, cVar);
                }
                List<c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<Void>>> list3 = this.f8698c;
                this.f8698c = new CopyOnWriteArrayList();
                for (c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<Void>> cVar2 : list3) {
                    this.f8704i.g(0, "success", null, cVar2);
                    for (c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>> cVar3 : list2) {
                        this.f8704i.g(0, "success", arrayList, cVar3);
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
        this.f8692e = false;
        this.f8693f = new CopyOnWriteArrayList();
        this.f8694g = new C0544a(this);
        this.a = context;
        this.f8689b = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        SwanWifiBroadcastReceiver swanWifiBroadcastReceiver = new SwanWifiBroadcastReceiver(this.f8689b);
        this.f8690c = swanWifiBroadcastReceiver;
        swanWifiBroadcastReceiver.setConnectSuccessListener(this.f8694g);
        this.f8691d = new c(this);
    }

    @Override // c.a.r0.a.r2.l.c.c
    public boolean b(c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) ? this.f8691d.b(cVar) : invokeL.booleanValue;
    }

    @Override // c.a.r0.a.r2.l.c.c
    public void c(c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f8691d.c(cVar);
        }
    }

    @Override // c.a.r0.a.r2.l.c.c
    public boolean d(c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<List<c.a.r0.a.r2.l.d.b>>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar)) == null) ? this.f8691d.d(cVar) : invokeL.booleanValue;
    }

    public <ResultType> void g(int i2, String str, ResultType resulttype, c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<ResultType>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, resulttype, cVar}) == null) || cVar == null) {
            return;
        }
        c.a.r0.a.r2.l.d.c<ResultType> cVar2 = new c.a.r0.a.r2.l.d.c<>();
        cVar2.a = i2;
        cVar2.f8729b = str;
        cVar2.f8730c = resulttype;
        cVar.onCallback(cVar2);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f8690c.unregisterSelf(this.a);
            this.f8693f = new CopyOnWriteArrayList();
            ((c) this.f8691d).n();
            o(false);
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f8690c.unregisterSelf(this.a);
            o(false);
        }
    }

    public void j(c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || cVar == null) {
            return;
        }
        q.k(new b(this, cVar), "getConnectedWifi");
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f8690c.registerSelf(this.a);
            o(true);
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f8692e : invokeV.booleanValue;
    }

    public final void m(WifiInfo wifiInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, wifiInfo) == null) {
            for (c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> cVar : this.f8693f) {
                g(0, "success", new c.a.r0.a.r2.l.d.b(wifiInfo, c.a.r0.a.r2.l.e.b.a(c.a.r0.a.r2.l.e.a.b(this.a, this.f8689b, wifiInfo))), cVar);
            }
        }
    }

    public boolean n(c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>>> list = this.f8693f;
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
            this.f8692e = z;
        }
    }

    public void p(c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            if (this.f8692e) {
                g(0, "success", null, cVar);
                return;
            }
            k();
            g(0, "success", null, cVar);
        }
    }

    public void q(c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<Void>> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            if (!this.f8692e) {
                g(0, "success", null, cVar);
                return;
            }
            i();
            g(0, "success", null, cVar);
        }
    }

    public boolean r(c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cVar)) == null) {
            if (cVar == null) {
                return false;
            }
            List<c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>>> list = this.f8693f;
            if (list.contains(cVar)) {
                return list.remove(cVar);
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
