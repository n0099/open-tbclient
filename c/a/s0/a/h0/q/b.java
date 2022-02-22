package c.a.s0.a.h0.q;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.k;
import c.a.s0.a.u.e.i.e;
import c.a.s0.a.u.e.i.g;
import c.a.s0.a.u.e.i.j;
import c.a.s0.a.u1.h;
import c.a.s0.a.u2.d;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.StatResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.v8engine.net.NetInfo;
import com.baidu.searchbox.v8engine.net.NetRequestCallback;
import com.baidu.searchbox.v8engine.net.NetRequestParam;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.v8.NodeJS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.HttpUrl;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f7066h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f7067i;

    /* renamed from: j  reason: collision with root package name */
    public static final Map<String, g> f7068j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final List<String> a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f7069b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, JSONObject> f7070c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f7071d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f7072e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f7073f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicInteger f7074g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7075e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f7076f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f7077g;

        public a(b bVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7077g = bVar;
            this.f7075e = str;
            this.f7076f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Set<String> g2 = c.a.s0.a.e2.a.c.g(this.f7075e);
                if (b.f7066h) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("startPreLink appId=");
                    sb.append(this.f7075e);
                    sb.append(" preLinkSet=");
                    sb.append(g2 == null ? 0 : g2.size());
                    sb.append(", hotLaunch=");
                    sb.append(this.f7076f);
                    sb.toString();
                }
                if (g2 != null && !g2.isEmpty()) {
                    this.f7077g.u(true);
                    this.f7077g.a.clear();
                    this.f7077g.f7074g.set(0);
                    b.f7068j.clear();
                    this.f7077g.f7069b = new ArrayList(g2);
                    int i2 = 0;
                    for (String str : g2) {
                        if (!TextUtils.isEmpty(str)) {
                            if (i2 >= 5) {
                                return;
                            }
                            String e2 = j.e(str);
                            if (!TextUtils.isEmpty(e2)) {
                                this.f7077g.a.add(e2);
                                this.f7077g.j(this.f7075e, i2, str, e2, true);
                                i2++;
                            }
                        }
                    }
                    return;
                }
                this.f7077g.z("校验失败", "请在开发者后台配置 prelink");
            }
        }
    }

    /* renamed from: c.a.s0.a.h0.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0425b implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f7078e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f7079f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f7080g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f7081h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f7082i;

        public C0425b(b bVar, String str, long j2, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, Long.valueOf(j2), Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7082i = bVar;
            this.f7078e = str;
            this.f7079f = j2;
            this.f7080g = z;
            this.f7081h = i2;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && b.f7066h) {
                String str = "doPrelink: onFail: " + exc.getMessage();
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) && b.f7066h) {
                String str = "doPrelink: onSuccess: " + i2;
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i2, networkStatRecord)) == null) {
                if (b.f7066h) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("doPrelink: parseResponse: url: ");
                    sb.append(this.f7078e);
                    sb.append(" response: ");
                    sb.append(response == null ? StringUtil.NULL_STRING : Integer.valueOf(response.code()));
                    sb.toString();
                }
                this.f7082i.t(this.f7079f, System.currentTimeMillis(), this.f7078e, networkStatRecord);
                if (networkStatRecord != null) {
                    long j2 = networkStatRecord.dnsEndTs - networkStatRecord.dnsStartTs;
                    long j3 = networkStatRecord.connTs - networkStatRecord.startTs;
                    if (b.f7066h) {
                        String str = "doPrelink: hit: url: " + this.f7078e;
                        String str2 = "doPrelink: isConnReused: " + networkStatRecord.isConnReused;
                        String str3 = "doPrelink: dnsTime: " + j2 + " connTime: " + j3;
                    }
                    int code = response != null ? response.code() : 0;
                    if (this.f7080g) {
                        this.f7082i.y(this.f7081h, "预连接请求返回", "code=" + code + " dns解析时长=" + j2 + "ms 网络连接时长=" + j3 + "ms url=" + this.f7078e);
                    }
                }
                this.f7082i.u(false);
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements NetRequestCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f7083b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f7084c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f7085d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f7086e;

        public c(b bVar, long j2, String str, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Long.valueOf(j2), str, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f7086e = bVar;
            this.a = j2;
            this.f7083b = str;
            this.f7084c = z;
            this.f7085d = i2;
        }

        @Override // com.baidu.searchbox.v8engine.net.NetRequestCallback
        public void onFailed(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (this.f7084c) {
                    b bVar = this.f7086e;
                    int i3 = this.f7085d;
                    bVar.y(i3, "预连接请求返回", "code=" + i2 + " msg=" + str);
                }
                this.f7086e.u(false);
            }
        }

        @Override // com.baidu.searchbox.v8engine.net.NetRequestCallback
        public void onSucceeded(String str, int i2, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, map) == null) {
                this.f7086e.t(this.a, System.currentTimeMillis(), this.f7083b, null);
                if (this.f7084c) {
                    b bVar = this.f7086e;
                    int i3 = this.f7085d;
                    bVar.y(i3, "预连接请求返回", "code=" + i2 + " url=" + this.f7083b);
                }
                this.f7086e.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1474414756, "Lc/a/s0/a/h0/q/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1474414756, "Lc/a/s0/a/h0/q/b;");
                return;
            }
        }
        f7066h = k.a;
        f7067i = null;
        f7068j = new ConcurrentHashMap();
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = Collections.synchronizedList(new ArrayList());
        this.f7070c = new HashMap();
        this.f7072e = new LinkedHashMap();
        this.f7073f = false;
        this.f7074g = new AtomicInteger(0);
    }

    public static void D(String str, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            g gVar = f7068j.get(str);
            if (gVar == null) {
                gVar = new g();
            }
            if (j2 > 0) {
                gVar.a = j2;
            }
            if (j3 > 0) {
                gVar.f9344b = j3;
            }
            if (j4 > 0) {
                gVar.f9345c = j4;
            }
            f7068j.put(str, gVar);
        }
    }

    public static b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f7067i == null) {
                synchronized (b.class) {
                    if (f7067i == null) {
                        f7067i = new b();
                    }
                }
            }
            return f7067i;
        }
        return (b) invokeV.objValue;
    }

    @NonNull
    public final synchronized String A() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("========== prelink start ==========");
                sb2.append("\r\n");
                for (Map.Entry<String, String> entry : this.f7072e.entrySet()) {
                    if (entry != null) {
                        sb2.append("----- ");
                        sb2.append(entry.getKey());
                        sb2.append(": ");
                        sb2.append(entry.getValue());
                        sb2.append("\r\n\r\n");
                    }
                }
                sb2.append("========== prelink end ==========");
                sb2.append("\r\n");
                sb = sb2.toString();
            }
            return sb;
        }
        return (String) invokeV.objValue;
    }

    public void B(@NonNull String str, @NonNull String str2, @NonNull NetInfo netInfo) {
        HybridUbcFlow d2;
        NetInfo.SwanExtra.Timing timing;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, netInfo) == null) && n() && this.f7071d != null && this.f7074g.get() != this.a.size() && this.f7071d.containsValue(str)) {
            StringBuilder sb = new StringBuilder();
            boolean z = false;
            sb.append("url=");
            sb.append(str2);
            sb.append("; ");
            if (netInfo.getSocket() != null) {
                z = netInfo.getSocket().mReused;
                sb.append("连接是否复用=");
                sb.append(netInfo.getSocket().mReused);
                sb.append("; ");
            }
            NetInfo.Timing timing2 = netInfo.getTiming();
            if (timing2 != null) {
                sb.append("DNS耗时=");
                sb.append(timing2.mDns / 1000);
                sb.append("ms; ");
                sb.append("连接耗时=");
                sb.append(timing2.mConnect / 1000);
                sb.append("ms; ");
            }
            y(this.f7074g.incrementAndGet() - 1, "业务方第一个同域名请求返回", sb.toString());
            if (this.f7074g.get() != 1 || (d2 = h.d(NodeJS.STARTUP_SCRIPT_NAME)) == null || timing2 == null) {
                return;
            }
            g remove = f7068j.remove(str);
            long j2 = remove != null ? remove.a : 0L;
            NetInfo.SwanExtra swanExtra = netInfo.getSwanExtra();
            long currentTimeMillis = (swanExtra == null || (timing = swanExtra.mTiming) == null) ? System.currentTimeMillis() : timing.mConnectTime + j2;
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("request_network_start");
            ubcFlowEvent.h(j2);
            d2.F(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("request_network_conn");
            ubcFlowEvent2.h((timing2.mConnect / 1000) + j2);
            d2.F(ubcFlowEvent2);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("request_dns_start");
            ubcFlowEvent3.h(j2);
            d2.F(ubcFlowEvent3);
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("request_dns_end");
            ubcFlowEvent4.h((timing2.mDns / 1000) + j2);
            d2.F(ubcFlowEvent4);
            UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("request_network_response");
            ubcFlowEvent5.h(currentTimeMillis);
            d2.F(ubcFlowEvent5);
            if (remove != null) {
                UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("request_interpret_start");
                ubcFlowEvent6.h(remove.f9344b);
                d2.F(ubcFlowEvent6);
                UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("request_interpret_end");
                ubcFlowEvent7.h(remove.f9345c);
                d2.F(ubcFlowEvent7);
            }
            d2.D("connResued", String.valueOf(z));
        }
    }

    public void C(@NonNull String str, @NonNull HttpUrl httpUrl, NetworkStatRecord networkStatRecord) {
        long j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, httpUrl, networkStatRecord) == null) || !n() || networkStatRecord == null || this.f7071d == null || this.f7074g.get() == this.a.size()) {
            return;
        }
        synchronized (b.class) {
            if (this.f7071d.containsValue(str)) {
                this.f7074g.incrementAndGet();
                long j3 = networkStatRecord.dnsEndTs;
                long j4 = networkStatRecord.dnsStartTs;
                long j5 = networkStatRecord.connTs;
                long j6 = networkStatRecord.startTs;
                long j7 = j3 - j4;
                long j8 = (j5 - j6) - j7;
                if (f7066h) {
                    StringBuilder sb = new StringBuilder();
                    j2 = j3;
                    sb.append("tryRecordNetworkStat: ");
                    sb.append(httpUrl);
                    sb.toString();
                    String str2 = "tryRecordNetworkStat: isConnReused: " + networkStatRecord.isConnReused;
                    String str3 = "tryRecordNetworkStat: dnsTime: " + j7 + " connTime: " + j8;
                } else {
                    j2 = j3;
                }
                y(this.f7074g.get() - 1, "业务方第一个同域名请求返回", " 连接是否复用=" + networkStatRecord.isConnReused + " dns解析时长=" + j7 + "ms 网络连接时长=" + j8 + "ms url=" + httpUrl);
                if (this.f7074g.get() <= 1) {
                    HybridUbcFlow p = h.p(NodeJS.STARTUP_SCRIPT_NAME);
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("request_network_start");
                    ubcFlowEvent.h(j6);
                    p.F(ubcFlowEvent);
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("request_network_conn");
                    ubcFlowEvent2.h(j5);
                    p.F(ubcFlowEvent2);
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("request_dns_start");
                    ubcFlowEvent3.h(j4);
                    p.F(ubcFlowEvent3);
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("request_dns_end");
                    ubcFlowEvent4.h(j2);
                    p.F(ubcFlowEvent4);
                    UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("request_network_response");
                    ubcFlowEvent5.h(networkStatRecord.responseTs);
                    p.F(ubcFlowEvent5);
                    UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("request_send_header");
                    ubcFlowEvent6.h(networkStatRecord.sendHeaderTs);
                    p.F(ubcFlowEvent6);
                    UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("request_receive_header");
                    ubcFlowEvent7.h(networkStatRecord.receiveHeaderTs);
                    p.F(ubcFlowEvent7);
                    p.D("connResued", String.valueOf(networkStatRecord.isConnReused));
                }
            }
        }
    }

    public boolean i(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str) || o()) {
                return false;
            }
            if (f7066h) {
                String str2 = "contains preLink request: " + this.f7071d.containsValue(str);
            }
            return this.f7071d.containsValue(str);
        }
        return invokeL.booleanValue;
    }

    @WorkerThread
    public final void j(String str, int i2, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Boolean.valueOf(z)}) == null) {
            if (f7066h) {
                String str4 = "doPrelink: " + str2;
            }
            if (!c.a.s0.a.h0.q.a.b(null, str, str2)) {
                if (z) {
                    y(i2, "预取阶段已连接", "url=" + str2 + " 不需要再次prelink");
                }
                if (f7066h) {
                    String str5 = "预取阶段已连接:, 不需要再连接，url = " + str2;
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c.a.s0.a.h0.q.a.d(str, str2);
            if (e.d()) {
                p(i2, str2, str3, z);
                return;
            }
            c.a.s0.p.d.a aVar = new c.a.s0.p.d.a();
            aVar.f11691b = "HEAD";
            HttpRequestBuilder a2 = c.a.s0.p.e.b.a(aVar);
            a2.setHeader("Referer", j.d());
            aVar.a = str2;
            aVar.f11695f = true;
            aVar.f11696g = false;
            aVar.f11697h = true;
            c.a.s0.p.e.a.g().u(a2, aVar);
            HttpRequest build = a2.enableStat(true).build();
            if (z) {
                y(i2, "校验通过", "开始向 url=" + str2 + " 发送预连接 HEAD 请求");
            }
            build.executeStat(new C0425b(this, str2, currentTimeMillis, z, i2));
        }
    }

    public long l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            g gVar = f7068j.get(str);
            if (gVar != null) {
                return gVar.a;
            }
            return 0L;
        }
        return invokeL.longValue;
    }

    public Set<String> m(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptySet();
            }
            Set<String> g2 = c.a.s0.a.e2.a.c.g(str);
            if (g2 == null) {
                return Collections.emptySet();
            }
            if (g2.size() <= 5 || !z) {
                return g2;
            }
            int i2 = 0;
            HashSet hashSet = new HashSet(5);
            for (String str2 : g2) {
                if (!TextUtils.isEmpty(str2)) {
                    int i3 = i2 + 1;
                    if (i2 >= 5) {
                        break;
                    }
                    hashSet.add(str2);
                    i2 = i3;
                }
            }
            return hashSet;
        }
        return (Set) invokeLZ.objValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? !this.a.isEmpty() : invokeV.booleanValue;
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Map<String, String> map = this.f7071d;
            return map == null || map.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public final void p(int i2, @NonNull String str, @NonNull String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, str2, Boolean.valueOf(z)}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.s0.a.h0.l.a W = c.a.s0.a.h0.u.g.U().W();
            if (W == null || !(W.g() instanceof c.a.s0.a.l0.a)) {
                return;
            }
            NetRequestParam.Builder builder = new NetRequestParam.Builder();
            builder.setUrl(str);
            builder.setMethod((byte) 2);
            NetRequestParam build = builder.build();
            build.setNetRequestCallback(new c(this, currentTimeMillis, str, z, i2));
            c.a.s0.a.l0.a aVar = (c.a.s0.a.l0.a) W.g();
            if (aVar.p0() != null) {
                if (z) {
                    y(i2, "校验通过", "开始向 url=" + str + " 发送预连接 HEAD 请求");
                }
                aVar.p0().execute(build);
            }
        }
    }

    public synchronized void q(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            synchronized (this) {
                if (n()) {
                    if (this.f7074g.get() == this.a.size()) {
                        if (f7066h) {
                            String str3 = "onBusinessRequest doRequest: " + str2;
                        }
                    } else if (this.f7069b == null || !this.f7069b.contains(str2)) {
                        String e2 = j.e(str2);
                        if (e2 != null && this.a.contains(e2)) {
                            if (this.f7071d == null) {
                                this.f7071d = new ArrayMap();
                            } else if (this.f7071d.containsKey(e2)) {
                                return;
                            }
                            this.f7071d.put(e2, str);
                            if (f7066h) {
                                String str4 = "onBusinessRequest hit: " + str2;
                            }
                            y(this.f7071d.size() - 1, "业务方触发第一个同域名请求", "url=" + str2);
                            return;
                        }
                        if (f7066h) {
                            String str5 = "onBusinessRequest: miss tag " + str2;
                        }
                    }
                }
            }
        }
    }

    public synchronized void r(@NonNull String str, @NonNull HttpUrl httpUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, httpUrl) == null) {
            synchronized (this) {
                if (n()) {
                    if (this.f7074g.get() == this.a.size()) {
                        if (f7066h) {
                            String str2 = "onBusinessRequest doRequest: " + httpUrl;
                        }
                        return;
                    }
                    String host = httpUrl.host();
                    if (host != null && this.a.contains(host)) {
                        if (this.f7071d == null) {
                            this.f7071d = new ArrayMap();
                        } else if (this.f7071d.containsKey(host)) {
                            return;
                        }
                        this.f7071d.put(host, str);
                        if (f7066h) {
                            String str3 = "onBusinessRequest hit: " + httpUrl;
                        }
                        y(this.f7071d.size() - 1, "业务方触发第一个同域名请求", "url=" + httpUrl);
                        return;
                    }
                    if (f7066h) {
                        String str4 = "onBusinessRequest: miss tag " + httpUrl.toString();
                    }
                }
            }
        }
    }

    @WorkerThread
    public void s(@NonNull String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, str2) == null) {
            if (TextUtils.isEmpty(str2)) {
                boolean z = f7066h;
                return;
            }
            String e2 = j.e(str2);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            j(str, -1, str2, e2, false);
        }
    }

    public final synchronized void t(long j2, long j3, String str, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str, networkStatRecord}) == null) {
            synchronized (this) {
                if (this.f7073f && !TextUtils.isEmpty(str)) {
                    c.a.s0.a.d2.e a0 = c.a.s0.a.d2.e.a0();
                    if (a0 != null && !TextUtils.isEmpty(a0.V().V())) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("url", str);
                            jSONObject.put("na_request", networkStatRecord == null ? "1" : "0");
                            jSONObject.put("start", j2);
                            jSONObject.put("end", j3);
                            if (networkStatRecord != null) {
                                jSONObject.put("net_type", networkStatRecord.netType);
                                jSONObject.put("start_connect", networkStatRecord.startTs);
                                jSONObject.put("start_dns", networkStatRecord.dnsStartTs);
                                jSONObject.put("end_dns", networkStatRecord.dnsEndTs);
                                jSONObject.put("on_connect", networkStatRecord.connTs);
                                jSONObject.put("send_header", networkStatRecord.sendHeaderTs);
                                jSONObject.put("recv_header", networkStatRecord.receiveHeaderTs);
                                jSONObject.put("response", networkStatRecord.responseTs);
                                jSONObject.put("response_finish", networkStatRecord.finishTs);
                            }
                            this.f7070c.put(str, jSONObject);
                        } catch (JSONException e2) {
                            if (f7066h) {
                                e2.printStackTrace();
                            }
                        }
                        JSONArray jSONArray = new JSONArray();
                        for (String str2 : this.f7070c.keySet()) {
                            jSONArray.put(this.f7070c.get(str2));
                        }
                        h.p(NodeJS.STARTUP_SCRIPT_NAME).D("prelinks", jSONArray.toString());
                        if (f7066h) {
                            String str3 = "in start app process, real prelink url - " + str;
                        }
                    }
                }
            }
        }
    }

    public final void u(boolean z) {
        HybridUbcFlow d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048590, this, z) == null) || (d2 = h.d(NodeJS.STARTUP_SCRIPT_NAME)) == null) {
            return;
        }
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent(z ? "prelink_request_start" : "prelink_request_end");
        ubcFlowEvent.h(System.currentTimeMillis());
        d2.F(ubcFlowEvent);
    }

    public synchronized void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            synchronized (this) {
                boolean z = f7066h;
                if (f7067i == null) {
                    return;
                }
                f7067i = null;
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && f7066h) {
            this.a.clear();
            f7068j.clear();
            this.f7071d = null;
        }
    }

    @AnyThread
    public synchronized void x(@Nullable String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, str, z) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    boolean z2 = f7066h;
                } else if (!z && this.f7073f) {
                    boolean z3 = f7066h;
                } else {
                    this.f7070c.clear();
                    this.f7073f = true;
                    ExecutorUtilsExt.postOnElastic(new a(this, str, z), "SwanPrelink", 0);
                }
            }
        }
    }

    public synchronized void y(@IntRange(from = -1) int i2, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048594, this, i2, str, str2) == null) {
            synchronized (this) {
                if (i2 >= 0) {
                    str = PreferencesUtil.LEFT_MOUNT + i2 + PreferencesUtil.RIGHT_MOUNT + str;
                }
                if (this.f7072e.containsKey(str)) {
                    return;
                }
                this.f7072e.put(str, str2);
                d.k.update((c.a.s0.a.u2.c<String>) A());
            }
        }
    }

    public synchronized void z(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, str2) == null) {
            synchronized (this) {
                y(-1, str, str2);
            }
        }
    }
}
