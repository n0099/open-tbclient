package c.a.p0.a.x.q;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.k.e.i.e;
import c.a.p0.a.k.e.i.g;
import c.a.p0.a.k.e.i.j;
import c.a.p0.a.k1.h;
import c.a.p0.a.k2.d;
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
    public static final boolean f8799h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f8800i;

    /* renamed from: j  reason: collision with root package name */
    public static final Map<String, g> f8801j;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final List<String> a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f8802b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, JSONObject> f8803c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f8804d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f8805e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f8806f;

    /* renamed from: g  reason: collision with root package name */
    public AtomicInteger f8807g;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8808e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f8809f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f8810g;

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
            this.f8810g = bVar;
            this.f8808e = str;
            this.f8809f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Set<String> g2 = c.a.p0.a.u1.a.c.g(this.f8808e);
                if (b.f8799h) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("startPreLink appId=");
                    sb.append(this.f8808e);
                    sb.append(" preLinkSet=");
                    sb.append(g2 == null ? 0 : g2.size());
                    sb.append(", hotLaunch=");
                    sb.append(this.f8809f);
                    sb.toString();
                }
                if (g2 != null && !g2.isEmpty()) {
                    this.f8810g.u(true);
                    this.f8810g.a.clear();
                    this.f8810g.f8807g.set(0);
                    b.f8801j.clear();
                    this.f8810g.f8802b = new ArrayList(g2);
                    int i2 = 0;
                    for (String str : g2) {
                        if (!TextUtils.isEmpty(str)) {
                            if (i2 >= 5) {
                                return;
                            }
                            String e2 = j.e(str);
                            if (!TextUtils.isEmpty(e2)) {
                                this.f8810g.a.add(e2);
                                this.f8810g.j(this.f8808e, i2, str, e2, true);
                                i2++;
                            }
                        }
                    }
                    return;
                }
                this.f8810g.z("校验失败", "请在开发者后台配置 prelink");
            }
        }
    }

    /* renamed from: c.a.p0.a.x.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0579b implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f8811e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f8812f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f8813g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f8814h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f8815i;

        public C0579b(b bVar, String str, long j2, boolean z, int i2) {
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
            this.f8815i = bVar;
            this.f8811e = str;
            this.f8812f = j2;
            this.f8813g = z;
            this.f8814h = i2;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && b.f8799h) {
                String str = "doPrelink: onFail: " + exc.getMessage();
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) && b.f8799h) {
                String str = "doPrelink: onSuccess: " + i2;
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i2, networkStatRecord)) == null) {
                if (b.f8799h) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("doPrelink: parseResponse: url: ");
                    sb.append(this.f8811e);
                    sb.append(" response: ");
                    sb.append(response == null ? StringUtil.NULL_STRING : Integer.valueOf(response.code()));
                    sb.toString();
                }
                this.f8815i.t(this.f8812f, System.currentTimeMillis(), this.f8811e, networkStatRecord);
                if (networkStatRecord != null) {
                    long j2 = networkStatRecord.dnsEndTs - networkStatRecord.dnsStartTs;
                    long j3 = networkStatRecord.connTs - networkStatRecord.startTs;
                    if (b.f8799h) {
                        String str = "doPrelink: hit: url: " + this.f8811e;
                        String str2 = "doPrelink: isConnReused: " + networkStatRecord.isConnReused;
                        String str3 = "doPrelink: dnsTime: " + j2 + " connTime: " + j3;
                    }
                    int code = response != null ? response.code() : 0;
                    if (this.f8813g) {
                        this.f8815i.y(this.f8814h, "预连接请求返回", "code=" + code + " dns解析时长=" + j2 + "ms 网络连接时长=" + j3 + "ms url=" + this.f8811e);
                    }
                }
                this.f8815i.u(false);
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
        public final /* synthetic */ String f8816b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f8817c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f8818d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8819e;

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
            this.f8819e = bVar;
            this.a = j2;
            this.f8816b = str;
            this.f8817c = z;
            this.f8818d = i2;
        }

        @Override // com.baidu.searchbox.v8engine.net.NetRequestCallback
        public void onFailed(int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
                if (this.f8817c) {
                    b bVar = this.f8819e;
                    int i3 = this.f8818d;
                    bVar.y(i3, "预连接请求返回", "code=" + i2 + " msg=" + str);
                }
                this.f8819e.u(false);
            }
        }

        @Override // com.baidu.searchbox.v8engine.net.NetRequestCallback
        public void onSucceeded(String str, int i2, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, map) == null) {
                this.f8819e.t(this.a, System.currentTimeMillis(), this.f8816b, null);
                if (this.f8817c) {
                    b bVar = this.f8819e;
                    int i3 = this.f8818d;
                    bVar.y(i3, "预连接请求返回", "code=" + i2 + " url=" + this.f8816b);
                }
                this.f8819e.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78475109, "Lc/a/p0/a/x/q/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78475109, "Lc/a/p0/a/x/q/b;");
                return;
            }
        }
        f8799h = c.a.p0.a.a.a;
        f8800i = null;
        f8801j = new ConcurrentHashMap();
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
        this.f8803c = new HashMap();
        this.f8805e = new LinkedHashMap();
        this.f8806f = false;
        this.f8807g = new AtomicInteger(0);
    }

    public static void D(String str, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)}) == null) {
            g gVar = f8801j.get(str);
            if (gVar == null) {
                gVar = new g();
            }
            if (j2 > 0) {
                gVar.a = j2;
            }
            if (j3 > 0) {
                gVar.f6072b = j3;
            }
            if (j4 > 0) {
                gVar.f6073c = j4;
            }
            f8801j.put(str, gVar);
        }
    }

    public static b k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            if (f8800i == null) {
                synchronized (b.class) {
                    if (f8800i == null) {
                        f8800i = new b();
                    }
                }
            }
            return f8800i;
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
                for (Map.Entry<String, String> entry : this.f8805e.entrySet()) {
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
        if ((interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, netInfo) == null) && n() && this.f8804d != null && this.f8807g.get() != this.a.size() && this.f8804d.containsValue(str)) {
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
            y(this.f8807g.incrementAndGet() - 1, "业务方第一个同域名请求返回", sb.toString());
            if (this.f8807g.get() != 1 || (d2 = h.d(NodeJS.STARTUP_SCRIPT_NAME)) == null || timing2 == null) {
                return;
            }
            g remove = f8801j.remove(str);
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
                ubcFlowEvent6.h(remove.f6072b);
                d2.F(ubcFlowEvent6);
                UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("request_interpret_end");
                ubcFlowEvent7.h(remove.f6073c);
                d2.F(ubcFlowEvent7);
            }
            d2.D("connResued", String.valueOf(z));
        }
    }

    public void C(@NonNull String str, @NonNull HttpUrl httpUrl, NetworkStatRecord networkStatRecord) {
        long j2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, str, httpUrl, networkStatRecord) == null) || !n() || networkStatRecord == null || this.f8804d == null || this.f8807g.get() == this.a.size()) {
            return;
        }
        synchronized (b.class) {
            if (this.f8804d.containsValue(str)) {
                this.f8807g.incrementAndGet();
                long j3 = networkStatRecord.dnsEndTs;
                long j4 = networkStatRecord.dnsStartTs;
                long j5 = networkStatRecord.connTs;
                long j6 = networkStatRecord.startTs;
                long j7 = j3 - j4;
                long j8 = (j5 - j6) - j7;
                if (f8799h) {
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
                y(this.f8807g.get() - 1, "业务方第一个同域名请求返回", " 连接是否复用=" + networkStatRecord.isConnReused + " dns解析时长=" + j7 + "ms 网络连接时长=" + j8 + "ms url=" + httpUrl);
                if (this.f8807g.get() <= 1) {
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
            if (f8799h) {
                String str2 = "contains preLink request: " + this.f8804d.containsValue(str);
            }
            return this.f8804d.containsValue(str);
        }
        return invokeL.booleanValue;
    }

    @WorkerThread
    public final void j(String str, int i2, @NonNull String str2, @NonNull String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Integer.valueOf(i2), str2, str3, Boolean.valueOf(z)}) == null) {
            if (f8799h) {
                String str4 = "doPrelink: " + str2;
            }
            if (!c.a.p0.a.x.q.a.b(null, str, str2)) {
                if (z) {
                    y(i2, "预取阶段已连接", "url=" + str2 + " 不需要再次prelink");
                }
                if (f8799h) {
                    String str5 = "预取阶段已连接:, 不需要再连接，url = " + str2;
                    return;
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            c.a.p0.a.x.q.a.d(str, str2);
            if (e.d()) {
                p(i2, str2, str3, z);
                return;
            }
            c.a.p0.p.d.a aVar = new c.a.p0.p.d.a();
            aVar.f10916b = "HEAD";
            HttpRequestBuilder a2 = c.a.p0.p.e.b.a(aVar);
            a2.setHeader("Referer", j.d());
            aVar.a = str2;
            aVar.f10920f = true;
            aVar.f10921g = false;
            aVar.f10922h = true;
            c.a.p0.p.e.a.g().u(a2, aVar);
            HttpRequest build = a2.enableStat(true).build();
            if (z) {
                y(i2, "校验通过", "开始向 url=" + str2 + " 发送预连接 HEAD 请求");
            }
            build.executeStat(new C0579b(this, str2, currentTimeMillis, z, i2));
        }
    }

    public long l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            g gVar = f8801j.get(str);
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
            Set<String> g2 = c.a.p0.a.u1.a.c.g(str);
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
            Map<String, String> map = this.f8804d;
            return map == null || map.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public final void p(int i2, @NonNull String str, @NonNull String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), str, str2, Boolean.valueOf(z)}) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            c.a.p0.a.x.l.a W = c.a.p0.a.x.u.g.U().W();
            if (W == null || !(W.g() instanceof c.a.p0.a.b0.a)) {
                return;
            }
            NetRequestParam.Builder builder = new NetRequestParam.Builder();
            builder.setUrl(str);
            builder.setMethod((byte) 2);
            NetRequestParam build = builder.build();
            build.setNetRequestCallback(new c(this, currentTimeMillis, str, z, i2));
            c.a.p0.a.b0.a aVar = (c.a.p0.a.b0.a) W.g();
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
                    if (this.f8807g.get() == this.a.size()) {
                        if (f8799h) {
                            String str3 = "onBusinessRequest doRequest: " + str2;
                        }
                    } else if (this.f8802b == null || !this.f8802b.contains(str2)) {
                        String e2 = j.e(str2);
                        if (e2 != null && this.a.contains(e2)) {
                            if (this.f8804d == null) {
                                this.f8804d = new ArrayMap();
                            } else if (this.f8804d.containsKey(e2)) {
                                return;
                            }
                            this.f8804d.put(e2, str);
                            if (f8799h) {
                                String str4 = "onBusinessRequest hit: " + str2;
                            }
                            y(this.f8804d.size() - 1, "业务方触发第一个同域名请求", "url=" + str2);
                            return;
                        }
                        if (f8799h) {
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
                    if (this.f8807g.get() == this.a.size()) {
                        if (f8799h) {
                            String str2 = "onBusinessRequest doRequest: " + httpUrl;
                        }
                        return;
                    }
                    String host = httpUrl.host();
                    if (host != null && this.a.contains(host)) {
                        if (this.f8804d == null) {
                            this.f8804d = new ArrayMap();
                        } else if (this.f8804d.containsKey(host)) {
                            return;
                        }
                        this.f8804d.put(host, str);
                        if (f8799h) {
                            String str3 = "onBusinessRequest hit: " + httpUrl;
                        }
                        y(this.f8804d.size() - 1, "业务方触发第一个同域名请求", "url=" + httpUrl);
                        return;
                    }
                    if (f8799h) {
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
                boolean z = f8799h;
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
                if (this.f8806f && !TextUtils.isEmpty(str)) {
                    c.a.p0.a.t1.e a0 = c.a.p0.a.t1.e.a0();
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
                            this.f8803c.put(str, jSONObject);
                        } catch (JSONException e2) {
                            if (f8799h) {
                                e2.printStackTrace();
                            }
                        }
                        JSONArray jSONArray = new JSONArray();
                        for (String str2 : this.f8803c.keySet()) {
                            jSONArray.put(this.f8803c.get(str2));
                        }
                        h.p(NodeJS.STARTUP_SCRIPT_NAME).D("prelinks", jSONArray.toString());
                        if (f8799h) {
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
                boolean z = f8799h;
                if (f8800i == null) {
                    return;
                }
                f8800i = null;
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && f8799h) {
            this.a.clear();
            f8801j.clear();
            this.f8804d = null;
        }
    }

    @AnyThread
    public synchronized void x(@Nullable String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048593, this, str, z) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    boolean z2 = f8799h;
                } else if (!z && this.f8806f) {
                    boolean z3 = f8799h;
                } else {
                    this.f8803c.clear();
                    this.f8806f = true;
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
                if (this.f8805e.containsKey(str)) {
                    return;
                }
                this.f8805e.put(str, str2);
                d.k.update((c.a.p0.a.k2.c<String>) A());
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
