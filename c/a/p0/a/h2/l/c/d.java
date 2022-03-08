package c.a.p0.a.h2.l.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import c.a.p0.a.p2.q;
import c.a.p0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.s;
import com.kuaishou.weapon.un.w0;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class d extends c.a.p0.a.h2.l.c.a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f5678i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.p0.a.h2.l.c.b f5679h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.h2.l.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> a;

        /* renamed from: b  reason: collision with root package name */
        public WifiConfiguration f5680b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5681c;

        /* renamed from: d  reason: collision with root package name */
        public final Handler f5682d;

        /* renamed from: e  reason: collision with root package name */
        public final Lock f5683e;

        /* renamed from: f  reason: collision with root package name */
        public final Runnable f5684f;

        /* renamed from: g  reason: collision with root package name */
        public final c.a.p0.a.h2.l.b.a f5685g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f5686h;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f5687e;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5687e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5687e.f5683e.lock();
                    try {
                        if (this.f5687e.a != null) {
                            this.f5687e.f5686h.g(12003, "connection timeout", null, this.f5687e.a);
                        }
                        this.f5687e.l();
                    } finally {
                        this.f5687e.f5683e.unlock();
                    }
                }
            }
        }

        /* renamed from: c.a.p0.a.h2.l.c.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0324b implements c.a.p0.a.h2.l.b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0324b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // c.a.p0.a.h2.l.b.b
            public void a(WifiInfo wifiInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                    if (wifiInfo == null) {
                        wifiInfo = this.a.f5686h.f5659b.getConnectionInfo();
                    }
                    this.a.f5683e.lock();
                    try {
                        if (this.a.f5680b != null && this.a.a != null && TextUtils.equals(wifiInfo.getSSID(), this.a.f5680b.SSID)) {
                            this.a.f5686h.g(0, "success", new c.a.p0.a.h2.l.d.b(wifiInfo, c.a.p0.a.h2.l.e.b.a(c.a.p0.a.h2.l.e.a.b(this.a.f5686h.a, this.a.f5686h.f5659b, wifiInfo))), this.a.a);
                            this.a.l();
                        }
                    } finally {
                        this.a.f5683e.unlock();
                    }
                }
            }

            @Override // c.a.p0.a.h2.l.b.a
            public void onError(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    this.a.f5683e.lock();
                    if (i2 == 1) {
                        try {
                            if (this.a.a != null) {
                                if (this.a.f5681c) {
                                    this.a.f5686h.g(TaskResponseData.ERROR_NO_TASK_OFFLINE_03, "password error", null, this.a.a);
                                } else {
                                    this.a.f5686h.g(12013, "wifi config unavailable", null, this.a.a);
                                }
                                this.a.l();
                            }
                        } finally {
                            this.a.f5683e.unlock();
                        }
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.p2.g1.c f5688e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.h2.l.d.a f5689f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f5690g;

            public c(b bVar, c.a.p0.a.p2.g1.c cVar, c.a.p0.a.h2.l.d.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5690g = bVar;
                this.f5688e = cVar;
                this.f5689f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int addNetwork;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        this.f5690g.f5686h.g(w0.I5, "not support", null, this.f5688e);
                    } else if (!this.f5690g.f5686h.l()) {
                        this.f5690g.f5686h.g(w0.X3, "not init", null, this.f5688e);
                    } else if (!this.f5690g.f5686h.f5659b.isWifiEnabled()) {
                        this.f5690g.f5686h.g(12005, "wifi is not on", null, this.f5688e);
                    } else if (!q0.K(this.f5690g.f5686h.a)) {
                        this.f5690g.f5686h.g(12006, "LBS is not on", null, this.f5688e);
                    } else if (ContextCompat.checkSelfPermission(this.f5690g.f5686h.a, s.f53808g) == 0) {
                        this.f5690g.f5683e.lock();
                        try {
                            if (this.f5690g.a == null) {
                                this.f5690g.a = this.f5688e;
                                this.f5690g.f5683e.unlock();
                                this.f5690g.f5680b = c.a.p0.a.h2.l.e.a.a(this.f5689f);
                                if (this.f5690g.f5680b != null) {
                                    if (!TextUtils.isEmpty(this.f5690g.f5680b.preSharedKey) && c.a.p0.a.h2.l.e.a.e(this.f5690g.f5680b.preSharedKey).length() < 8) {
                                        b bVar = this.f5690g;
                                        bVar.f5686h.g(TaskResponseData.ERROR_NO_TASK_OFFLINE_03, "password error", null, bVar.a);
                                        this.f5690g.l();
                                        return;
                                    }
                                    WifiInfo connectionInfo = this.f5690g.f5686h.f5659b.getConnectionInfo();
                                    if (connectionInfo != null && connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
                                        connectionInfo = null;
                                    }
                                    boolean z = false;
                                    if (connectionInfo != null && !TextUtils.equals(connectionInfo.getSSID(), "<unknown ssid>") && TextUtils.equals(this.f5690g.f5680b.SSID, connectionInfo.getSSID()) && (TextUtils.isEmpty(this.f5690g.f5680b.BSSID) || (!TextUtils.isEmpty(this.f5690g.f5680b.BSSID) && TextUtils.equals(this.f5690g.f5680b.BSSID, connectionInfo.getBSSID())))) {
                                        d dVar = this.f5690g.f5686h;
                                        dVar.g(0, "success", new c.a.p0.a.h2.l.d.b(connectionInfo, c.a.p0.a.h2.l.e.b.a(c.a.p0.a.h2.l.e.a.b(dVar.a, dVar.f5659b, connectionInfo))), this.f5688e);
                                        this.f5690g.l();
                                        return;
                                    }
                                    d dVar2 = this.f5690g.f5686h;
                                    WifiConfiguration c2 = c.a.p0.a.h2.l.e.a.c(dVar2.a, dVar2.f5659b, this.f5689f);
                                    if (c2 != null) {
                                        this.f5690g.f5680b.networkId = c2.networkId;
                                    }
                                    if (this.f5690g.f5680b.networkId > -1) {
                                        b bVar2 = this.f5690g;
                                        addNetwork = bVar2.f5686h.f5659b.updateNetwork(bVar2.f5680b);
                                        if (addNetwork < 0 && c2 != null && !TextUtils.isEmpty(this.f5690g.f5680b.BSSID) && !TextUtils.equals(this.f5690g.f5680b.BSSID, c2.BSSID)) {
                                            this.f5690g.f5686h.g(12013, "wifi config unavailable", null, this.f5688e);
                                            this.f5690g.l();
                                            return;
                                        } else if (connectionInfo != null && addNetwork == connectionInfo.getNetworkId() && !TextUtils.isEmpty(this.f5690g.f5680b.BSSID) && !TextUtils.equals(this.f5690g.f5680b.BSSID, connectionInfo.getBSSID())) {
                                            this.f5690g.f5686h.g(12013, "wifi config unavailable", null, this.f5688e);
                                            this.f5690g.l();
                                            return;
                                        }
                                    } else {
                                        b bVar3 = this.f5690g;
                                        addNetwork = bVar3.f5686h.f5659b.addNetwork(bVar3.f5680b);
                                    }
                                    this.f5690g.f5681c = addNetwork >= 0;
                                    if (addNetwork < 0 && this.f5690g.f5680b.networkId > -1) {
                                        addNetwork = this.f5690g.f5680b.networkId;
                                    }
                                    if (addNetwork >= 0) {
                                        this.f5690g.f5682d.postDelayed(this.f5690g.f5684f, 16000L);
                                        z = this.f5690g.f5686h.f5659b.enableNetwork(addNetwork, true);
                                        this.f5690g.f5686h.f5659b.saveConfiguration();
                                    }
                                    if (z) {
                                        return;
                                    }
                                    this.f5690g.f5686h.g(12013, "wifi config unavailable", null, this.f5688e);
                                    this.f5690g.l();
                                    return;
                                }
                                this.f5690g.f5686h.g(12008, "invalid ssid", null, this.f5688e);
                                this.f5690g.l();
                                return;
                            }
                            this.f5690g.f5686h.g(12004, "is connecting", null, this.f5688e);
                        } finally {
                            this.f5690g.f5683e.unlock();
                        }
                    } else {
                        this.f5690g.f5686h.g(12012, "no location permission", null, this.f5688e);
                    }
                }
            }
        }

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5686h = dVar;
            this.f5682d = new Handler(Looper.getMainLooper());
            this.f5683e = new ReentrantLock();
            this.f5684f = new a(this);
            C0324b c0324b = new C0324b(this);
            this.f5685g = c0324b;
            dVar.f5660c.setConnectListener(c0324b);
        }

        @Override // c.a.p0.a.h2.l.c.b
        public void a(c.a.p0.a.h2.l.d.a aVar, c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
                return;
            }
            q.k(new c(this, cVar, aVar), "connectWifi");
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f5683e.lock();
                try {
                    this.f5682d.removeCallbacks(this.f5684f);
                    this.f5680b = null;
                    this.a = null;
                } finally {
                    this.f5683e.unlock();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.h2.l.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public c(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.p0.a.h2.l.c.b
        public void a(c.a.p0.a.h2.l.d.a aVar, c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
                return;
            }
            this.a.g(w0.I5, "not support", null, cVar);
        }

        public /* synthetic */ c(d dVar, a aVar) {
            this(dVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (Build.VERSION.SDK_INT < 29) {
            this.f5679h = new b(this);
        } else {
            this.f5679h = new c(this, null);
        }
    }

    public static d s(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f5678i == null) {
                synchronized (d.class) {
                    if (f5678i == null) {
                        f5678i = new d(context);
                    }
                }
            }
            return f5678i;
        }
        return (d) invokeL.objValue;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || f5678i == null) {
            return;
        }
        f5678i.h();
        f5678i = null;
    }

    @Override // c.a.p0.a.h2.l.c.b
    public void a(c.a.p0.a.h2.l.d.a aVar, c.a.p0.a.p2.g1.c<c.a.p0.a.h2.l.d.c<c.a.p0.a.h2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
            return;
        }
        if (aVar != null && aVar.f5694e) {
            t();
            g(0, "success", null, cVar);
            return;
        }
        this.f5679h.a(aVar, cVar);
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Intent intent = new Intent();
            intent.setAction("android.settings.WIFI_SETTINGS");
            if (!(this.a instanceof Activity)) {
                intent.addFlags(268435456);
            }
            this.a.startActivity(intent);
        }
    }
}
