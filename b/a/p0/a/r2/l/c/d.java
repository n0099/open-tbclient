package b.a.p0.a.r2.l.c;

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
import b.a.p0.a.z2.q;
import b.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class d extends b.a.p0.a.r2.l.c.a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f8258i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final b.a.p0.a.r2.l.c.b f8259h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements b.a.p0.a.r2.l.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> f8260a;

        /* renamed from: b  reason: collision with root package name */
        public WifiConfiguration f8261b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8262c;

        /* renamed from: d  reason: collision with root package name */
        public final Handler f8263d;

        /* renamed from: e  reason: collision with root package name */
        public final Lock f8264e;

        /* renamed from: f  reason: collision with root package name */
        public final Runnable f8265f;

        /* renamed from: g  reason: collision with root package name */
        public final b.a.p0.a.r2.l.b.a f8266g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f8267h;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8268e;

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
                this.f8268e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8268e.f8264e.lock();
                    try {
                        if (this.f8268e.f8260a != null) {
                            this.f8268e.f8267h.g(12003, "connection timeout", null, this.f8268e.f8260a);
                        }
                        this.f8268e.l();
                    } finally {
                        this.f8268e.f8264e.unlock();
                    }
                }
            }
        }

        /* renamed from: b.a.p0.a.r2.l.c.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0398b implements b.a.p0.a.r2.l.b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f8269a;

            public C0398b(b bVar) {
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
                this.f8269a = bVar;
            }

            @Override // b.a.p0.a.r2.l.b.b
            public void a(WifiInfo wifiInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                    if (wifiInfo == null) {
                        wifiInfo = this.f8269a.f8267h.f8236b.getConnectionInfo();
                    }
                    this.f8269a.f8264e.lock();
                    try {
                        if (this.f8269a.f8261b != null && this.f8269a.f8260a != null && TextUtils.equals(wifiInfo.getSSID(), this.f8269a.f8261b.SSID)) {
                            this.f8269a.f8267h.g(0, "success", new b.a.p0.a.r2.l.d.b(wifiInfo, b.a.p0.a.r2.l.e.b.a(b.a.p0.a.r2.l.e.a.b(this.f8269a.f8267h.f8235a, this.f8269a.f8267h.f8236b, wifiInfo))), this.f8269a.f8260a);
                            this.f8269a.l();
                        }
                    } finally {
                        this.f8269a.f8264e.unlock();
                    }
                }
            }

            @Override // b.a.p0.a.r2.l.b.a
            public void onError(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    this.f8269a.f8264e.lock();
                    if (i2 == 1) {
                        try {
                            if (this.f8269a.f8260a != null) {
                                if (this.f8269a.f8262c) {
                                    this.f8269a.f8267h.g(12002, "password error", null, this.f8269a.f8260a);
                                } else {
                                    this.f8269a.f8267h.g(12013, "wifi config unavailable", null, this.f8269a.f8260a);
                                }
                                this.f8269a.l();
                            }
                        } finally {
                            this.f8269a.f8264e.unlock();
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
            public final /* synthetic */ b.a.p0.a.z2.g1.c f8270e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b.a.p0.a.r2.l.d.a f8271f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f8272g;

            public c(b bVar, b.a.p0.a.z2.g1.c cVar, b.a.p0.a.r2.l.d.a aVar) {
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
                this.f8272g = bVar;
                this.f8270e = cVar;
                this.f8271f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int addNetwork;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        this.f8272g.f8267h.g(12001, "not support", null, this.f8270e);
                    } else if (!this.f8272g.f8267h.l()) {
                        this.f8272g.f8267h.g(12000, "not init", null, this.f8270e);
                    } else if (!this.f8272g.f8267h.f8236b.isWifiEnabled()) {
                        this.f8272g.f8267h.g(CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK, "wifi is not on", null, this.f8270e);
                    } else if (!q0.K(this.f8272g.f8267h.f8235a)) {
                        this.f8272g.f8267h.g(CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, "LBS is not on", null, this.f8270e);
                    } else if (ContextCompat.checkSelfPermission(this.f8272g.f8267h.f8235a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        this.f8272g.f8264e.lock();
                        try {
                            if (this.f8272g.f8260a == null) {
                                this.f8272g.f8260a = this.f8270e;
                                this.f8272g.f8264e.unlock();
                                this.f8272g.f8261b = b.a.p0.a.r2.l.e.a.a(this.f8271f);
                                if (this.f8272g.f8261b != null) {
                                    if (!TextUtils.isEmpty(this.f8272g.f8261b.preSharedKey) && b.a.p0.a.r2.l.e.a.e(this.f8272g.f8261b.preSharedKey).length() < 8) {
                                        b bVar = this.f8272g;
                                        bVar.f8267h.g(12002, "password error", null, bVar.f8260a);
                                        this.f8272g.l();
                                        return;
                                    }
                                    WifiInfo connectionInfo = this.f8272g.f8267h.f8236b.getConnectionInfo();
                                    if (connectionInfo != null && connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
                                        connectionInfo = null;
                                    }
                                    boolean z = false;
                                    if (connectionInfo != null && !TextUtils.equals(connectionInfo.getSSID(), "<unknown ssid>") && TextUtils.equals(this.f8272g.f8261b.SSID, connectionInfo.getSSID()) && (TextUtils.isEmpty(this.f8272g.f8261b.BSSID) || (!TextUtils.isEmpty(this.f8272g.f8261b.BSSID) && TextUtils.equals(this.f8272g.f8261b.BSSID, connectionInfo.getBSSID())))) {
                                        d dVar = this.f8272g.f8267h;
                                        dVar.g(0, "success", new b.a.p0.a.r2.l.d.b(connectionInfo, b.a.p0.a.r2.l.e.b.a(b.a.p0.a.r2.l.e.a.b(dVar.f8235a, dVar.f8236b, connectionInfo))), this.f8270e);
                                        this.f8272g.l();
                                        return;
                                    }
                                    d dVar2 = this.f8272g.f8267h;
                                    WifiConfiguration c2 = b.a.p0.a.r2.l.e.a.c(dVar2.f8235a, dVar2.f8236b, this.f8271f);
                                    if (c2 != null) {
                                        this.f8272g.f8261b.networkId = c2.networkId;
                                    }
                                    if (this.f8272g.f8261b.networkId > -1) {
                                        b bVar2 = this.f8272g;
                                        addNetwork = bVar2.f8267h.f8236b.updateNetwork(bVar2.f8261b);
                                        if (addNetwork < 0 && c2 != null && !TextUtils.isEmpty(this.f8272g.f8261b.BSSID) && !TextUtils.equals(this.f8272g.f8261b.BSSID, c2.BSSID)) {
                                            this.f8272g.f8267h.g(12013, "wifi config unavailable", null, this.f8270e);
                                            this.f8272g.l();
                                            return;
                                        } else if (connectionInfo != null && addNetwork == connectionInfo.getNetworkId() && !TextUtils.isEmpty(this.f8272g.f8261b.BSSID) && !TextUtils.equals(this.f8272g.f8261b.BSSID, connectionInfo.getBSSID())) {
                                            this.f8272g.f8267h.g(12013, "wifi config unavailable", null, this.f8270e);
                                            this.f8272g.l();
                                            return;
                                        }
                                    } else {
                                        b bVar3 = this.f8272g;
                                        addNetwork = bVar3.f8267h.f8236b.addNetwork(bVar3.f8261b);
                                    }
                                    this.f8272g.f8262c = addNetwork >= 0;
                                    if (addNetwork < 0 && this.f8272g.f8261b.networkId > -1) {
                                        addNetwork = this.f8272g.f8261b.networkId;
                                    }
                                    if (addNetwork >= 0) {
                                        this.f8272g.f8263d.postDelayed(this.f8272g.f8265f, 16000L);
                                        z = this.f8272g.f8267h.f8236b.enableNetwork(addNetwork, true);
                                        this.f8272g.f8267h.f8236b.saveConfiguration();
                                    }
                                    if (z) {
                                        return;
                                    }
                                    this.f8272g.f8267h.g(12013, "wifi config unavailable", null, this.f8270e);
                                    this.f8272g.l();
                                    return;
                                }
                                this.f8272g.f8267h.g(12008, "invalid ssid", null, this.f8270e);
                                this.f8272g.l();
                                return;
                            }
                            this.f8272g.f8267h.g(12004, "is connecting", null, this.f8270e);
                        } finally {
                            this.f8272g.f8264e.unlock();
                        }
                    } else {
                        this.f8272g.f8267h.g(12012, "no location permission", null, this.f8270e);
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
            this.f8267h = dVar;
            this.f8263d = new Handler(Looper.getMainLooper());
            this.f8264e = new ReentrantLock();
            this.f8265f = new a(this);
            C0398b c0398b = new C0398b(this);
            this.f8266g = c0398b;
            dVar.f8237c.setConnectListener(c0398b);
        }

        @Override // b.a.p0.a.r2.l.c.b
        public void a(b.a.p0.a.r2.l.d.a aVar, b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
                return;
            }
            q.k(new c(this, cVar, aVar), "connectWifi");
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f8264e.lock();
                try {
                    this.f8263d.removeCallbacks(this.f8265f);
                    this.f8261b = null;
                    this.f8260a = null;
                } finally {
                    this.f8264e.unlock();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements b.a.p0.a.r2.l.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f8273a;

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
            this.f8273a = dVar;
        }

        @Override // b.a.p0.a.r2.l.c.b
        public void a(b.a.p0.a.r2.l.d.a aVar, b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
                return;
            }
            this.f8273a.g(12001, "not support", null, cVar);
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
            this.f8259h = new b(this);
        } else {
            this.f8259h = new c(this, null);
        }
    }

    public static d s(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f8258i == null) {
                synchronized (d.class) {
                    if (f8258i == null) {
                        f8258i = new d(context);
                    }
                }
            }
            return f8258i;
        }
        return (d) invokeL.objValue;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || f8258i == null) {
            return;
        }
        f8258i.h();
        f8258i = null;
    }

    @Override // b.a.p0.a.r2.l.c.b
    public void a(b.a.p0.a.r2.l.d.a aVar, b.a.p0.a.z2.g1.c<b.a.p0.a.r2.l.d.c<b.a.p0.a.r2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
            return;
        }
        if (aVar != null && aVar.f8278e) {
            t();
            g(0, "success", null, cVar);
            return;
        }
        this.f8259h.a(aVar, cVar);
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Intent intent = new Intent();
            intent.setAction("android.settings.WIFI_SETTINGS");
            if (!(this.f8235a instanceof Activity)) {
                intent.addFlags(268435456);
            }
            this.f8235a.startActivity(intent);
        }
    }
}
