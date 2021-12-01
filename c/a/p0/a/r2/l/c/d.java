package c.a.p0.a.r2.l.c;

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
import c.a.p0.a.z2.q;
import c.a.p0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
public class d extends c.a.p0.a.r2.l.c.a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: i  reason: collision with root package name */
    public static volatile d f7859i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.p0.a.r2.l.c.b f7860h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements c.a.p0.a.r2.l.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> a;

        /* renamed from: b  reason: collision with root package name */
        public WifiConfiguration f7861b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7862c;

        /* renamed from: d  reason: collision with root package name */
        public final Handler f7863d;

        /* renamed from: e  reason: collision with root package name */
        public final Lock f7864e;

        /* renamed from: f  reason: collision with root package name */
        public final Runnable f7865f;

        /* renamed from: g  reason: collision with root package name */
        public final c.a.p0.a.r2.l.b.a f7866g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f7867h;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f7868e;

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
                this.f7868e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f7868e.f7864e.lock();
                    try {
                        if (this.f7868e.a != null) {
                            this.f7868e.f7867h.g(12003, "connection timeout", null, this.f7868e.a);
                        }
                        this.f7868e.l();
                    } finally {
                        this.f7868e.f7864e.unlock();
                    }
                }
            }
        }

        /* renamed from: c.a.p0.a.r2.l.c.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0454b implements c.a.p0.a.r2.l.b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0454b(b bVar) {
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

            @Override // c.a.p0.a.r2.l.b.b
            public void a(WifiInfo wifiInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                    if (wifiInfo == null) {
                        wifiInfo = this.a.f7867h.f7840b.getConnectionInfo();
                    }
                    this.a.f7864e.lock();
                    try {
                        if (this.a.f7861b != null && this.a.a != null && TextUtils.equals(wifiInfo.getSSID(), this.a.f7861b.SSID)) {
                            this.a.f7867h.g(0, "success", new c.a.p0.a.r2.l.d.b(wifiInfo, c.a.p0.a.r2.l.e.b.a(c.a.p0.a.r2.l.e.a.b(this.a.f7867h.a, this.a.f7867h.f7840b, wifiInfo))), this.a.a);
                            this.a.l();
                        }
                    } finally {
                        this.a.f7864e.unlock();
                    }
                }
            }

            @Override // c.a.p0.a.r2.l.b.a
            public void onError(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    this.a.f7864e.lock();
                    if (i2 == 1) {
                        try {
                            if (this.a.a != null) {
                                if (this.a.f7862c) {
                                    this.a.f7867h.g(12002, "password error", null, this.a.a);
                                } else {
                                    this.a.f7867h.g(12013, "wifi config unavailable", null, this.a.a);
                                }
                                this.a.l();
                            }
                        } finally {
                            this.a.f7864e.unlock();
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
            public final /* synthetic */ c.a.p0.a.z2.g1.c f7869e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.p0.a.r2.l.d.a f7870f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f7871g;

            public c(b bVar, c.a.p0.a.z2.g1.c cVar, c.a.p0.a.r2.l.d.a aVar) {
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
                this.f7871g = bVar;
                this.f7869e = cVar;
                this.f7870f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int addNetwork;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        this.f7871g.f7867h.g(w0.I5, "not support", null, this.f7869e);
                    } else if (!this.f7871g.f7867h.l()) {
                        this.f7871g.f7867h.g(w0.X3, "not init", null, this.f7869e);
                    } else if (!this.f7871g.f7867h.f7840b.isWifiEnabled()) {
                        this.f7871g.f7867h.g(CyberPlayerManager.MEDIA_INFO_WEAK_NETWORK_BEST_RANK, "wifi is not on", null, this.f7869e);
                    } else if (!q0.K(this.f7871g.f7867h.a)) {
                        this.f7871g.f7867h.g(CyberPlayerManager.MEDIA_INFO_PRERENDER_COMPLETE, "LBS is not on", null, this.f7869e);
                    } else if (ContextCompat.checkSelfPermission(this.f7871g.f7867h.a, s.f56842g) == 0) {
                        this.f7871g.f7864e.lock();
                        try {
                            if (this.f7871g.a == null) {
                                this.f7871g.a = this.f7869e;
                                this.f7871g.f7864e.unlock();
                                this.f7871g.f7861b = c.a.p0.a.r2.l.e.a.a(this.f7870f);
                                if (this.f7871g.f7861b != null) {
                                    if (!TextUtils.isEmpty(this.f7871g.f7861b.preSharedKey) && c.a.p0.a.r2.l.e.a.e(this.f7871g.f7861b.preSharedKey).length() < 8) {
                                        b bVar = this.f7871g;
                                        bVar.f7867h.g(12002, "password error", null, bVar.a);
                                        this.f7871g.l();
                                        return;
                                    }
                                    WifiInfo connectionInfo = this.f7871g.f7867h.f7840b.getConnectionInfo();
                                    if (connectionInfo != null && connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
                                        connectionInfo = null;
                                    }
                                    boolean z = false;
                                    if (connectionInfo != null && !TextUtils.equals(connectionInfo.getSSID(), "<unknown ssid>") && TextUtils.equals(this.f7871g.f7861b.SSID, connectionInfo.getSSID()) && (TextUtils.isEmpty(this.f7871g.f7861b.BSSID) || (!TextUtils.isEmpty(this.f7871g.f7861b.BSSID) && TextUtils.equals(this.f7871g.f7861b.BSSID, connectionInfo.getBSSID())))) {
                                        d dVar = this.f7871g.f7867h;
                                        dVar.g(0, "success", new c.a.p0.a.r2.l.d.b(connectionInfo, c.a.p0.a.r2.l.e.b.a(c.a.p0.a.r2.l.e.a.b(dVar.a, dVar.f7840b, connectionInfo))), this.f7869e);
                                        this.f7871g.l();
                                        return;
                                    }
                                    d dVar2 = this.f7871g.f7867h;
                                    WifiConfiguration c2 = c.a.p0.a.r2.l.e.a.c(dVar2.a, dVar2.f7840b, this.f7870f);
                                    if (c2 != null) {
                                        this.f7871g.f7861b.networkId = c2.networkId;
                                    }
                                    if (this.f7871g.f7861b.networkId > -1) {
                                        b bVar2 = this.f7871g;
                                        addNetwork = bVar2.f7867h.f7840b.updateNetwork(bVar2.f7861b);
                                        if (addNetwork < 0 && c2 != null && !TextUtils.isEmpty(this.f7871g.f7861b.BSSID) && !TextUtils.equals(this.f7871g.f7861b.BSSID, c2.BSSID)) {
                                            this.f7871g.f7867h.g(12013, "wifi config unavailable", null, this.f7869e);
                                            this.f7871g.l();
                                            return;
                                        } else if (connectionInfo != null && addNetwork == connectionInfo.getNetworkId() && !TextUtils.isEmpty(this.f7871g.f7861b.BSSID) && !TextUtils.equals(this.f7871g.f7861b.BSSID, connectionInfo.getBSSID())) {
                                            this.f7871g.f7867h.g(12013, "wifi config unavailable", null, this.f7869e);
                                            this.f7871g.l();
                                            return;
                                        }
                                    } else {
                                        b bVar3 = this.f7871g;
                                        addNetwork = bVar3.f7867h.f7840b.addNetwork(bVar3.f7861b);
                                    }
                                    this.f7871g.f7862c = addNetwork >= 0;
                                    if (addNetwork < 0 && this.f7871g.f7861b.networkId > -1) {
                                        addNetwork = this.f7871g.f7861b.networkId;
                                    }
                                    if (addNetwork >= 0) {
                                        this.f7871g.f7863d.postDelayed(this.f7871g.f7865f, 16000L);
                                        z = this.f7871g.f7867h.f7840b.enableNetwork(addNetwork, true);
                                        this.f7871g.f7867h.f7840b.saveConfiguration();
                                    }
                                    if (z) {
                                        return;
                                    }
                                    this.f7871g.f7867h.g(12013, "wifi config unavailable", null, this.f7869e);
                                    this.f7871g.l();
                                    return;
                                }
                                this.f7871g.f7867h.g(12008, "invalid ssid", null, this.f7869e);
                                this.f7871g.l();
                                return;
                            }
                            this.f7871g.f7867h.g(12004, "is connecting", null, this.f7869e);
                        } finally {
                            this.f7871g.f7864e.unlock();
                        }
                    } else {
                        this.f7871g.f7867h.g(12012, "no location permission", null, this.f7869e);
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
            this.f7867h = dVar;
            this.f7863d = new Handler(Looper.getMainLooper());
            this.f7864e = new ReentrantLock();
            this.f7865f = new a(this);
            C0454b c0454b = new C0454b(this);
            this.f7866g = c0454b;
            dVar.f7841c.setConnectListener(c0454b);
        }

        @Override // c.a.p0.a.r2.l.c.b
        public void a(c.a.p0.a.r2.l.d.a aVar, c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
                return;
            }
            q.k(new c(this, cVar, aVar), "connectWifi");
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f7864e.lock();
                try {
                    this.f7863d.removeCallbacks(this.f7865f);
                    this.f7861b = null;
                    this.a = null;
                } finally {
                    this.f7864e.unlock();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.p0.a.r2.l.c.b {
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

        @Override // c.a.p0.a.r2.l.c.b
        public void a(c.a.p0.a.r2.l.d.a aVar, c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> cVar) {
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
            this.f7860h = new b(this);
        } else {
            this.f7860h = new c(this, null);
        }
    }

    public static d s(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f7859i == null) {
                synchronized (d.class) {
                    if (f7859i == null) {
                        f7859i = new d(context);
                    }
                }
            }
            return f7859i;
        }
        return (d) invokeL.objValue;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || f7859i == null) {
            return;
        }
        f7859i.h();
        f7859i = null;
    }

    @Override // c.a.p0.a.r2.l.c.b
    public void a(c.a.p0.a.r2.l.d.a aVar, c.a.p0.a.z2.g1.c<c.a.p0.a.r2.l.d.c<c.a.p0.a.r2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
            return;
        }
        if (aVar != null && aVar.f7875e) {
            t();
            g(0, "success", null, cVar);
            return;
        }
        this.f7860h.a(aVar, cVar);
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
