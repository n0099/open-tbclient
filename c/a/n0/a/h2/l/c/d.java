package c.a.n0.a.h2.l.c;

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
import c.a.n0.a.p2.q;
import c.a.n0.a.p2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public class d extends c.a.n0.a.h2.l.c.a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile d i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final c.a.n0.a.h2.l.c.b f4796h;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public class b implements c.a.n0.a.h2.l.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> a;

        /* renamed from: b  reason: collision with root package name */
        public WifiConfiguration f4797b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f4798c;

        /* renamed from: d  reason: collision with root package name */
        public final Handler f4799d;

        /* renamed from: e  reason: collision with root package name */
        public final Lock f4800e;

        /* renamed from: f  reason: collision with root package name */
        public final Runnable f4801f;

        /* renamed from: g  reason: collision with root package name */
        public final c.a.n0.a.h2.l.b.a f4802g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d f4803h;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.f4800e.lock();
                    try {
                        if (this.a.a != null) {
                            this.a.f4803h.g(12003, "connection timeout", null, this.a.a);
                        }
                        this.a.l();
                    } finally {
                        this.a.f4800e.unlock();
                    }
                }
            }
        }

        /* renamed from: c.a.n0.a.h2.l.c.d$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0312b implements c.a.n0.a.h2.l.b.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            public C0312b(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // c.a.n0.a.h2.l.b.b
            public void a(WifiInfo wifiInfo) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, wifiInfo) == null) {
                    if (wifiInfo == null) {
                        wifiInfo = this.a.f4803h.f4781b.getConnectionInfo();
                    }
                    this.a.f4800e.lock();
                    try {
                        if (this.a.f4797b != null && this.a.a != null && TextUtils.equals(wifiInfo.getSSID(), this.a.f4797b.SSID)) {
                            this.a.f4803h.g(0, "success", new c.a.n0.a.h2.l.d.b(wifiInfo, c.a.n0.a.h2.l.e.b.a(c.a.n0.a.h2.l.e.a.b(this.a.f4803h.a, this.a.f4803h.f4781b, wifiInfo))), this.a.a);
                            this.a.l();
                        }
                    } finally {
                        this.a.f4800e.unlock();
                    }
                }
            }

            @Override // c.a.n0.a.h2.l.b.a
            public void onError(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                    this.a.f4800e.lock();
                    if (i == 1) {
                        try {
                            if (this.a.a != null) {
                                if (this.a.f4798c) {
                                    this.a.f4803h.g(TaskResponseData.ERROR_NO_TASK_OFFLINE_03, "password error", null, this.a.a);
                                } else {
                                    this.a.f4803h.g(12013, "wifi config unavailable", null, this.a.a);
                                }
                                this.a.l();
                            }
                        } finally {
                            this.a.f4800e.unlock();
                        }
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c.a.n0.a.p2.g1.c a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ c.a.n0.a.h2.l.d.a f4804b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f4805c;

            public c(b bVar, c.a.n0.a.p2.g1.c cVar, c.a.n0.a.h2.l.d.a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, cVar, aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4805c = bVar;
                this.a = cVar;
                this.f4804b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                int addNetwork;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        this.f4805c.f4803h.g(w0.I5, "not support", null, this.a);
                    } else if (!this.f4805c.f4803h.l()) {
                        this.f4805c.f4803h.g(w0.X3, "not init", null, this.a);
                    } else if (!this.f4805c.f4803h.f4781b.isWifiEnabled()) {
                        this.f4805c.f4803h.g(12005, "wifi is not on", null, this.a);
                    } else if (!q0.K(this.f4805c.f4803h.a)) {
                        this.f4805c.f4803h.g(12006, "LBS is not on", null, this.a);
                    } else if (ContextCompat.checkSelfPermission(this.f4805c.f4803h.a, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        this.f4805c.f4800e.lock();
                        try {
                            if (this.f4805c.a == null) {
                                this.f4805c.a = this.a;
                                this.f4805c.f4800e.unlock();
                                this.f4805c.f4797b = c.a.n0.a.h2.l.e.a.a(this.f4804b);
                                if (this.f4805c.f4797b != null) {
                                    if (!TextUtils.isEmpty(this.f4805c.f4797b.preSharedKey) && c.a.n0.a.h2.l.e.a.e(this.f4805c.f4797b.preSharedKey).length() < 8) {
                                        b bVar = this.f4805c;
                                        bVar.f4803h.g(TaskResponseData.ERROR_NO_TASK_OFFLINE_03, "password error", null, bVar.a);
                                        this.f4805c.l();
                                        return;
                                    }
                                    WifiInfo connectionInfo = this.f4805c.f4803h.f4781b.getConnectionInfo();
                                    if (connectionInfo != null && connectionInfo.getSupplicantState() != SupplicantState.COMPLETED) {
                                        connectionInfo = null;
                                    }
                                    boolean z = false;
                                    if (connectionInfo != null && !TextUtils.equals(connectionInfo.getSSID(), "<unknown ssid>") && TextUtils.equals(this.f4805c.f4797b.SSID, connectionInfo.getSSID()) && (TextUtils.isEmpty(this.f4805c.f4797b.BSSID) || (!TextUtils.isEmpty(this.f4805c.f4797b.BSSID) && TextUtils.equals(this.f4805c.f4797b.BSSID, connectionInfo.getBSSID())))) {
                                        d dVar = this.f4805c.f4803h;
                                        dVar.g(0, "success", new c.a.n0.a.h2.l.d.b(connectionInfo, c.a.n0.a.h2.l.e.b.a(c.a.n0.a.h2.l.e.a.b(dVar.a, dVar.f4781b, connectionInfo))), this.a);
                                        this.f4805c.l();
                                        return;
                                    }
                                    d dVar2 = this.f4805c.f4803h;
                                    WifiConfiguration c2 = c.a.n0.a.h2.l.e.a.c(dVar2.a, dVar2.f4781b, this.f4804b);
                                    if (c2 != null) {
                                        this.f4805c.f4797b.networkId = c2.networkId;
                                    }
                                    if (this.f4805c.f4797b.networkId > -1) {
                                        b bVar2 = this.f4805c;
                                        addNetwork = bVar2.f4803h.f4781b.updateNetwork(bVar2.f4797b);
                                        if (addNetwork < 0 && c2 != null && !TextUtils.isEmpty(this.f4805c.f4797b.BSSID) && !TextUtils.equals(this.f4805c.f4797b.BSSID, c2.BSSID)) {
                                            this.f4805c.f4803h.g(12013, "wifi config unavailable", null, this.a);
                                            this.f4805c.l();
                                            return;
                                        } else if (connectionInfo != null && addNetwork == connectionInfo.getNetworkId() && !TextUtils.isEmpty(this.f4805c.f4797b.BSSID) && !TextUtils.equals(this.f4805c.f4797b.BSSID, connectionInfo.getBSSID())) {
                                            this.f4805c.f4803h.g(12013, "wifi config unavailable", null, this.a);
                                            this.f4805c.l();
                                            return;
                                        }
                                    } else {
                                        b bVar3 = this.f4805c;
                                        addNetwork = bVar3.f4803h.f4781b.addNetwork(bVar3.f4797b);
                                    }
                                    this.f4805c.f4798c = addNetwork >= 0;
                                    if (addNetwork < 0 && this.f4805c.f4797b.networkId > -1) {
                                        addNetwork = this.f4805c.f4797b.networkId;
                                    }
                                    if (addNetwork >= 0) {
                                        this.f4805c.f4799d.postDelayed(this.f4805c.f4801f, 16000L);
                                        z = this.f4805c.f4803h.f4781b.enableNetwork(addNetwork, true);
                                        this.f4805c.f4803h.f4781b.saveConfiguration();
                                    }
                                    if (z) {
                                        return;
                                    }
                                    this.f4805c.f4803h.g(12013, "wifi config unavailable", null, this.a);
                                    this.f4805c.l();
                                    return;
                                }
                                this.f4805c.f4803h.g(12008, "invalid ssid", null, this.a);
                                this.f4805c.l();
                                return;
                            }
                            this.f4805c.f4803h.g(12004, "is connecting", null, this.a);
                        } finally {
                            this.f4805c.f4800e.unlock();
                        }
                    } else {
                        this.f4805c.f4803h.g(12012, "no location permission", null, this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4803h = dVar;
            this.f4799d = new Handler(Looper.getMainLooper());
            this.f4800e = new ReentrantLock();
            this.f4801f = new a(this);
            C0312b c0312b = new C0312b(this);
            this.f4802g = c0312b;
            dVar.f4782c.setConnectListener(c0312b);
        }

        @Override // c.a.n0.a.h2.l.c.b
        public void a(c.a.n0.a.h2.l.d.a aVar, c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> cVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
                return;
            }
            q.k(new c(this, cVar, aVar), "connectWifi");
        }

        public final void l() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f4800e.lock();
                try {
                    this.f4799d.removeCallbacks(this.f4801f);
                    this.f4797b = null;
                    this.a = null;
                } finally {
                    this.f4800e.unlock();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements c.a.n0.a.h2.l.c.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // c.a.n0.a.h2.l.c.b
        public void a(c.a.n0.a.h2.l.d.a aVar, c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> cVar) {
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
            this.f4796h = new b(this);
        } else {
            this.f4796h = new c(this, null);
        }
    }

    public static d s(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (i == null) {
                synchronized (d.class) {
                    if (i == null) {
                        i = new d(context);
                    }
                }
            }
            return i;
        }
        return (d) invokeL.objValue;
    }

    public static void u() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, null) == null) || i == null) {
            return;
        }
        i.h();
        i = null;
    }

    @Override // c.a.n0.a.h2.l.c.b
    public void a(c.a.n0.a.h2.l.d.a aVar, c.a.n0.a.p2.g1.c<c.a.n0.a.h2.l.d.c<c.a.n0.a.h2.l.d.b>> cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, cVar) == null) || cVar == null) {
            return;
        }
        if (aVar != null && aVar.f4809e) {
            t();
            g(0, "success", null, cVar);
            return;
        }
        this.f4796h.a(aVar, cVar);
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Intent intent = new Intent();
            intent.setAction("android.settings.WIFI_SETTINGS");
            if (!(this.a instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            this.a.startActivity(intent);
        }
    }
}
