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
    public static volatile d f8850i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.r0.a.r2.l.c.b f8851h;

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
        public WifiConfiguration f8852b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f8853c;

        /* renamed from: d  reason: collision with root package name */
        public final Handler f8854d;

        /* renamed from: e  reason: collision with root package name */
        public final Lock f8855e;

        /* renamed from: f  reason: collision with root package name */
        public final Runnable f8856f;

        /* renamed from: g  reason: collision with root package name */
        public final c.a.r0.a.r2.l.b.a f8857g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f8858h;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f8859e;

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
                this.f8859e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f8859e.f8855e.lock();
                    try {
                        if (this.f8859e.a != null) {
                            this.f8859e.f8858h.g(12003, "connection timeout", null, this.f8859e.a);
                        }
                        this.f8859e.l();
                    } finally {
                        this.f8859e.f8855e.unlock();
                    }
                }
            }
        }

        /* renamed from: c.a.r0.a.r2.l.c.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0556b implements c.a.r0.a.r2.l.b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0556b(b bVar) {
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
                        wifiInfo = this.a.f8858h.f8831b.getConnectionInfo();
                    }
                    this.a.f8855e.lock();
                    try {
                        if (this.a.f8852b != null && this.a.a != null && TextUtils.equals(wifiInfo.getSSID(), this.a.f8852b.SSID)) {
                            this.a.f8858h.g(0, "success", new c.a.r0.a.r2.l.d.b(wifiInfo, c.a.r0.a.r2.l.e.b.a(c.a.r0.a.r2.l.e.a.b(this.a.f8858h.a, this.a.f8858h.f8831b, wifiInfo))), this.a.a);
                            this.a.l();
                        }
                    } finally {
                        this.a.f8855e.unlock();
                    }
                }
            }

            @Override // c.a.r0.a.r2.l.b.a
            public void onError(int i2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                    this.a.f8855e.lock();
                    if (i2 == 1) {
                        try {
                            if (this.a.a != null) {
                                if (this.a.f8853c) {
                                    this.a.f8858h.g(TaskResponseData.ERROR_NO_TASK_OFFLINE_03, "password error", null, this.a.a);
                                } else {
                                    this.a.f8858h.g(12013, "wifi config unavailable", null, this.a.a);
                                }
                                this.a.l();
                            }
                        } finally {
                            this.a.f8855e.unlock();
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
            public final /* synthetic */ c.a.r0.a.z2.g1.c f8860e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ c.a.r0.a.r2.l.d.a f8861f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ b f8862g;

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
                this.f8862g = bVar;
                this.f8860e = cVar;
                this.f8861f = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int addNetwork;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        this.f8862g.f8858h.g(w0.I5, "not support", null, this.f8860e);
                    } else if (!this.f8862g.f8858h.l()) {
                        this.f8862g.f8858h.g(w0.X3, "not init", null, this.f8860e);
                    } else if (!this.f8862g.f8858h.f8831b.isWifiEnabled()) {
                        this.f8862g.f8858h.g(12005, "wifi is not on", null, this.f8860e);
                    } else if (!q0.K(this.f8862g.f8858h.a)) {
                        this.f8862g.f8858h.g(12006, "LBS is not on", null, this.f8860e);
                    } else if (ContextCompat.checkSelfPermission(this.f8862g.f8858h.a, s.f55291g) == 0) {
                        this.f8862g.f8855e.lock();
                        try {
                            if (this.f8862g.a == null) {
                                this.f8862g.a = this.f8860e;
                                this.f8862g.f8855e.unlock();
                                this.f8862g.f8852b = c.a.r0.a.r2.l.e.a.a(this.f8861f);
                                if (this.f8862g.f8852b != null) {
                                    if (!TextUtils.isEmpty(this.f8862g.f8852b.preSharedKey) && c.a.r0.a.r2.l.e.a.e(this.f8862g.f8852b.preSharedKey).length() < 8) {
                                        b bVar = this.f8862g;
                                        bVar.f8858h.g(TaskResponseData.ERROR_NO_TASK_OFFLINE_03, "password error", null, bVar.a);
                                        this.f8862g.l();
                                        return;
                                    }
                                    WifiInfo connectionInfo = this.f8862g.f8858h.f8831b.getConnectionInfo();
                                    if (connectionInfo != null && connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
                                        connectionInfo = null;
                                    }
                                    boolean z = false;
                                    if (connectionInfo != null && !TextUtils.equals(connectionInfo.getSSID(), "<unknown ssid>") && TextUtils.equals(this.f8862g.f8852b.SSID, connectionInfo.getSSID()) && (TextUtils.isEmpty(this.f8862g.f8852b.BSSID) || (!TextUtils.isEmpty(this.f8862g.f8852b.BSSID) && TextUtils.equals(this.f8862g.f8852b.BSSID, connectionInfo.getBSSID())))) {
                                        d dVar = this.f8862g.f8858h;
                                        dVar.g(0, "success", new c.a.r0.a.r2.l.d.b(connectionInfo, c.a.r0.a.r2.l.e.b.a(c.a.r0.a.r2.l.e.a.b(dVar.a, dVar.f8831b, connectionInfo))), this.f8860e);
                                        this.f8862g.l();
                                        return;
                                    }
                                    d dVar2 = this.f8862g.f8858h;
                                    WifiConfiguration c2 = c.a.r0.a.r2.l.e.a.c(dVar2.a, dVar2.f8831b, this.f8861f);
                                    if (c2 != null) {
                                        this.f8862g.f8852b.networkId = c2.networkId;
                                    }
                                    if (this.f8862g.f8852b.networkId > -1) {
                                        b bVar2 = this.f8862g;
                                        addNetwork = bVar2.f8858h.f8831b.updateNetwork(bVar2.f8852b);
                                        if (addNetwork < 0 && c2 != null && !TextUtils.isEmpty(this.f8862g.f8852b.BSSID) && !TextUtils.equals(this.f8862g.f8852b.BSSID, c2.BSSID)) {
                                            this.f8862g.f8858h.g(12013, "wifi config unavailable", null, this.f8860e);
                                            this.f8862g.l();
                                            return;
                                        } else if (connectionInfo != null && addNetwork == connectionInfo.getNetworkId() && !TextUtils.isEmpty(this.f8862g.f8852b.BSSID) && !TextUtils.equals(this.f8862g.f8852b.BSSID, connectionInfo.getBSSID())) {
                                            this.f8862g.f8858h.g(12013, "wifi config unavailable", null, this.f8860e);
                                            this.f8862g.l();
                                            return;
                                        }
                                    } else {
                                        b bVar3 = this.f8862g;
                                        addNetwork = bVar3.f8858h.f8831b.addNetwork(bVar3.f8852b);
                                    }
                                    this.f8862g.f8853c = addNetwork >= 0;
                                    if (addNetwork < 0 && this.f8862g.f8852b.networkId > -1) {
                                        addNetwork = this.f8862g.f8852b.networkId;
                                    }
                                    if (addNetwork >= 0) {
                                        this.f8862g.f8854d.postDelayed(this.f8862g.f8856f, 16000L);
                                        z = this.f8862g.f8858h.f8831b.enableNetwork(addNetwork, true);
                                        this.f8862g.f8858h.f8831b.saveConfiguration();
                                    }
                                    if (z) {
                                        return;
                                    }
                                    this.f8862g.f8858h.g(12013, "wifi config unavailable", null, this.f8860e);
                                    this.f8862g.l();
                                    return;
                                }
                                this.f8862g.f8858h.g(12008, "invalid ssid", null, this.f8860e);
                                this.f8862g.l();
                                return;
                            }
                            this.f8862g.f8858h.g(12004, "is connecting", null, this.f8860e);
                        } finally {
                            this.f8862g.f8855e.unlock();
                        }
                    } else {
                        this.f8862g.f8858h.g(12012, "no location permission", null, this.f8860e);
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
            this.f8858h = dVar;
            this.f8854d = new Handler(Looper.getMainLooper());
            this.f8855e = new ReentrantLock();
            this.f8856f = new a(this);
            C0556b c0556b = new C0556b(this);
            this.f8857g = c0556b;
            dVar.f8832c.setConnectListener(c0556b);
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
                this.f8855e.lock();
                try {
                    this.f8854d.removeCallbacks(this.f8856f);
                    this.f8852b = null;
                    this.a = null;
                } finally {
                    this.f8855e.unlock();
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
            this.f8851h = new b(this);
        } else {
            this.f8851h = new c(this, null);
        }
    }

    public static d s(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f8850i == null) {
                synchronized (d.class) {
                    if (f8850i == null) {
                        f8850i = new d(context);
                    }
                }
            }
            return f8850i;
        }
        return (d) invokeL.objValue;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || f8850i == null) {
            return;
        }
        f8850i.h();
        f8850i = null;
    }

    @Override // c.a.r0.a.r2.l.c.b
    public void a(c.a.r0.a.r2.l.d.a aVar, c.a.r0.a.z2.g1.c<c.a.r0.a.r2.l.d.c<c.a.r0.a.r2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
            return;
        }
        if (aVar != null && aVar.f8866e) {
            t();
            g(0, "success", null, cVar);
            return;
        }
        this.f8851h.a(aVar, cVar);
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
