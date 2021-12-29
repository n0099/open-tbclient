package c.a.r0.a.r2.l.c;

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
import c.a.r0.a.z2.q;
import c.a.r0.a.z2.q0;
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
public class d extends c.a.r0.a.r2.l.c.a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f8903i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.a.r2.l.c.b f8904h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements c.a.r0.a.r2.l.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> a;

        /* renamed from: b  reason: collision with root package name */
        public WifiConfiguration f8905b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8906c;

        /* renamed from: d  reason: collision with root package name */
        public final Handler f8907d;

        /* renamed from: e  reason: collision with root package name */
        public final Lock f8908e;

        /* renamed from: f  reason: collision with root package name */
        public final Runnable f8909f;

        /* renamed from: g  reason: collision with root package name */
        public final c.a.r0.a.r2.l.b.a f8910g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f8911h;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8912e;

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
                this.f8912e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8912e.f8908e.lock();
                    try {
                        if (this.f8912e.a != null) {
                            this.f8912e.f8911h.g(12003, "connection timeout", null, this.f8912e.a);
                        }
                        this.f8912e.l();
                    } finally {
                        this.f8912e.f8908e.unlock();
                    }
                }
            }
        }

        /* renamed from: c.a.r0.a.r2.l.c.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0538b implements c.a.r0.a.r2.l.b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0538b(b bVar) {
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

            @Override // c.a.r0.a.r2.l.b.b
            public void a(WifiInfo wifiInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                    if (wifiInfo == null) {
                        wifiInfo = this.a.f8911h.f8884b.getConnectionInfo();
                    }
                    this.a.f8908e.lock();
                    try {
                        if (this.a.f8905b != null && this.a.a != null && TextUtils.equals(wifiInfo.getSSID(), this.a.f8905b.SSID)) {
                            this.a.f8911h.g(0, "success", new c.a.r0.a.r2.l.d.b(wifiInfo, c.a.r0.a.r2.l.e.b.a(c.a.r0.a.r2.l.e.a.b(this.a.f8911h.a, this.a.f8911h.f8884b, wifiInfo))), this.a.a);
                            this.a.l();
                        }
                    } finally {
                        this.a.f8908e.unlock();
                    }
                }
            }

            @Override // c.a.r0.a.r2.l.b.a
            public void onError(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    this.a.f8908e.lock();
                    if (i2 == 1) {
                        try {
                            if (this.a.a != null) {
                                if (this.a.f8906c) {
                                    this.a.f8911h.g(TaskResponseData.ERROR_NO_TASK_OFFLINE_03, "password error", null, this.a.a);
                                } else {
                                    this.a.f8911h.g(12013, "wifi config unavailable", null, this.a.a);
                                }
                                this.a.l();
                            }
                        } finally {
                            this.a.f8908e.unlock();
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
            public final /* synthetic */ c.a.r0.a.z2.g1.c f8913e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r2.l.d.a f8914f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f8915g;

            public c(b bVar, c.a.r0.a.z2.g1.c cVar, c.a.r0.a.r2.l.d.a aVar) {
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
                this.f8915g = bVar;
                this.f8913e = cVar;
                this.f8914f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int addNetwork;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        this.f8915g.f8911h.g(w0.I5, "not support", null, this.f8913e);
                    } else if (!this.f8915g.f8911h.l()) {
                        this.f8915g.f8911h.g(w0.X3, "not init", null, this.f8913e);
                    } else if (!this.f8915g.f8911h.f8884b.isWifiEnabled()) {
                        this.f8915g.f8911h.g(12005, "wifi is not on", null, this.f8913e);
                    } else if (!q0.K(this.f8915g.f8911h.a)) {
                        this.f8915g.f8911h.g(12006, "LBS is not on", null, this.f8913e);
                    } else if (ContextCompat.checkSelfPermission(this.f8915g.f8911h.a, s.f57423g) == 0) {
                        this.f8915g.f8908e.lock();
                        try {
                            if (this.f8915g.a == null) {
                                this.f8915g.a = this.f8913e;
                                this.f8915g.f8908e.unlock();
                                this.f8915g.f8905b = c.a.r0.a.r2.l.e.a.a(this.f8914f);
                                if (this.f8915g.f8905b != null) {
                                    if (!TextUtils.isEmpty(this.f8915g.f8905b.preSharedKey) && c.a.r0.a.r2.l.e.a.e(this.f8915g.f8905b.preSharedKey).length() < 8) {
                                        b bVar = this.f8915g;
                                        bVar.f8911h.g(TaskResponseData.ERROR_NO_TASK_OFFLINE_03, "password error", null, bVar.a);
                                        this.f8915g.l();
                                        return;
                                    }
                                    WifiInfo connectionInfo = this.f8915g.f8911h.f8884b.getConnectionInfo();
                                    if (connectionInfo != null && connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
                                        connectionInfo = null;
                                    }
                                    boolean z = false;
                                    if (connectionInfo != null && !TextUtils.equals(connectionInfo.getSSID(), "<unknown ssid>") && TextUtils.equals(this.f8915g.f8905b.SSID, connectionInfo.getSSID()) && (TextUtils.isEmpty(this.f8915g.f8905b.BSSID) || (!TextUtils.isEmpty(this.f8915g.f8905b.BSSID) && TextUtils.equals(this.f8915g.f8905b.BSSID, connectionInfo.getBSSID())))) {
                                        d dVar = this.f8915g.f8911h;
                                        dVar.g(0, "success", new c.a.r0.a.r2.l.d.b(connectionInfo, c.a.r0.a.r2.l.e.b.a(c.a.r0.a.r2.l.e.a.b(dVar.a, dVar.f8884b, connectionInfo))), this.f8913e);
                                        this.f8915g.l();
                                        return;
                                    }
                                    d dVar2 = this.f8915g.f8911h;
                                    WifiConfiguration c2 = c.a.r0.a.r2.l.e.a.c(dVar2.a, dVar2.f8884b, this.f8914f);
                                    if (c2 != null) {
                                        this.f8915g.f8905b.networkId = c2.networkId;
                                    }
                                    if (this.f8915g.f8905b.networkId > -1) {
                                        b bVar2 = this.f8915g;
                                        addNetwork = bVar2.f8911h.f8884b.updateNetwork(bVar2.f8905b);
                                        if (addNetwork < 0 && c2 != null && !TextUtils.isEmpty(this.f8915g.f8905b.BSSID) && !TextUtils.equals(this.f8915g.f8905b.BSSID, c2.BSSID)) {
                                            this.f8915g.f8911h.g(12013, "wifi config unavailable", null, this.f8913e);
                                            this.f8915g.l();
                                            return;
                                        } else if (connectionInfo != null && addNetwork == connectionInfo.getNetworkId() && !TextUtils.isEmpty(this.f8915g.f8905b.BSSID) && !TextUtils.equals(this.f8915g.f8905b.BSSID, connectionInfo.getBSSID())) {
                                            this.f8915g.f8911h.g(12013, "wifi config unavailable", null, this.f8913e);
                                            this.f8915g.l();
                                            return;
                                        }
                                    } else {
                                        b bVar3 = this.f8915g;
                                        addNetwork = bVar3.f8911h.f8884b.addNetwork(bVar3.f8905b);
                                    }
                                    this.f8915g.f8906c = addNetwork >= 0;
                                    if (addNetwork < 0 && this.f8915g.f8905b.networkId > -1) {
                                        addNetwork = this.f8915g.f8905b.networkId;
                                    }
                                    if (addNetwork >= 0) {
                                        this.f8915g.f8907d.postDelayed(this.f8915g.f8909f, 16000L);
                                        z = this.f8915g.f8911h.f8884b.enableNetwork(addNetwork, true);
                                        this.f8915g.f8911h.f8884b.saveConfiguration();
                                    }
                                    if (z) {
                                        return;
                                    }
                                    this.f8915g.f8911h.g(12013, "wifi config unavailable", null, this.f8913e);
                                    this.f8915g.l();
                                    return;
                                }
                                this.f8915g.f8911h.g(12008, "invalid ssid", null, this.f8913e);
                                this.f8915g.l();
                                return;
                            }
                            this.f8915g.f8911h.g(12004, "is connecting", null, this.f8913e);
                        } finally {
                            this.f8915g.f8908e.unlock();
                        }
                    } else {
                        this.f8915g.f8911h.g(12012, "no location permission", null, this.f8913e);
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
            this.f8911h = dVar;
            this.f8907d = new Handler(Looper.getMainLooper());
            this.f8908e = new ReentrantLock();
            this.f8909f = new a(this);
            C0538b c0538b = new C0538b(this);
            this.f8910g = c0538b;
            dVar.f8885c.setConnectListener(c0538b);
        }

        @Override // c.a.r0.a.r2.l.c.b
        public void a(c.a.r0.a.r2.l.d.a aVar, c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
                return;
            }
            q.k(new c(this, cVar, aVar), "connectWifi");
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f8908e.lock();
                try {
                    this.f8907d.removeCallbacks(this.f8909f);
                    this.f8905b = null;
                    this.a = null;
                } finally {
                    this.f8908e.unlock();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.r0.a.r2.l.c.b {
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

        @Override // c.a.r0.a.r2.l.c.b
        public void a(c.a.r0.a.r2.l.d.a aVar, c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> cVar) {
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
            this.f8904h = new b(this);
        } else {
            this.f8904h = new c(this, null);
        }
    }

    public static d s(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f8903i == null) {
                synchronized (d.class) {
                    if (f8903i == null) {
                        f8903i = new d(context);
                    }
                }
            }
            return f8903i;
        }
        return (d) invokeL.objValue;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || f8903i == null) {
            return;
        }
        f8903i.h();
        f8903i = null;
    }

    @Override // c.a.r0.a.r2.l.c.b
    public void a(c.a.r0.a.r2.l.d.a aVar, c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
            return;
        }
        if (aVar != null && aVar.f8919e) {
            t();
            g(0, "success", null, cVar);
            return;
        }
        this.f8904h.a(aVar, cVar);
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
