package b.a.p0.a.h0.q;

import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.h0.u.g;
import b.a.p0.a.k;
import b.a.p0.a.u.e.j.d;
import b.a.p0.a.u.e.j.h;
import com.android.internal.http.multipart.Part;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.HttpUrl;
import okhttp3.Response;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f5720g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile b f5721h;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f5722a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f5723b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f5724c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f5725d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5726e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f5727f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5728e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f5729f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f5730g;

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
            this.f5730g = bVar;
            this.f5728e = str;
            this.f5729f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Set<String> g2 = b.a.p0.a.b2.a.c.g(this.f5728e);
                int i2 = 0;
                if (b.f5720g) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("startPreLink appId=");
                    sb.append(this.f5728e);
                    sb.append(" preLinkSet=");
                    sb.append(g2 == null ? 0 : g2.size());
                    sb.append(", hotLaunch=");
                    sb.append(this.f5729f);
                    sb.toString();
                }
                if (g2 != null && !g2.isEmpty()) {
                    this.f5730g.f5722a.clear();
                    this.f5730g.f5727f.set(0);
                    this.f5730g.f5723b = new ArrayList(g2);
                    for (String str : g2) {
                        if (!TextUtils.isEmpty(str)) {
                            if (i2 >= 5) {
                                return;
                            }
                            String e2 = h.e(str);
                            if (!TextUtils.isEmpty(e2)) {
                                this.f5730g.f5722a.add(e2);
                                this.f5730g.f(i2, str, e2, true);
                                i2++;
                            }
                        }
                    }
                    return;
                }
                this.f5730g.r("校验失败", "请在开发者后台配置 prelink");
            }
        }
    }

    /* renamed from: b.a.p0.a.h0.q.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0244b implements StatResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5731e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f5732f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f5733g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b f5734h;

        public C0244b(b bVar, String str, boolean z, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, Boolean.valueOf(z), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5734h = bVar;
            this.f5731e = str;
            this.f5732f = z;
            this.f5733g = i2;
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, exc) == null) && b.f5720g) {
                String str = "doPrelink: onFail: " + exc.getMessage();
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public void onSuccess(Object obj, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i2) == null) && b.f5720g) {
                String str = "doPrelink: onSuccess: " + i2;
            }
        }

        @Override // com.baidu.searchbox.http.callback.StatResponseCallback
        public Object parseResponse(Response response, int i2, NetworkStatRecord networkStatRecord) throws Exception {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, response, i2, networkStatRecord)) == null) {
                if (b.f5720g) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("doPrelink: parseResponse: url: ");
                    sb.append(this.f5731e);
                    sb.append(" response: ");
                    sb.append(response == null ? StringUtil.NULL_STRING : Integer.valueOf(response.code()));
                    sb.toString();
                }
                if (networkStatRecord != null) {
                    long j = networkStatRecord.dnsEndTs - networkStatRecord.dnsStartTs;
                    long j2 = networkStatRecord.connTs - networkStatRecord.startTs;
                    if (b.f5720g) {
                        String str = "doPrelink: hit: url: " + this.f5731e;
                        String str2 = "doPrelink: isConnReused: " + networkStatRecord.isConnReused;
                        String str3 = "doPrelink: dnsTime: " + j + " connTime: " + j2;
                    }
                    int code = response != null ? response.code() : 0;
                    if (this.f5732f) {
                        this.f5734h.q(this.f5733g, "预连接请求返回", "code=" + code + " dns解析时长=" + j + "ms 网络连接时长=" + j2 + "ms url=" + this.f5731e);
                    }
                }
                return response;
            }
            return invokeLIL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class c implements NetRequestCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f5735a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f5736b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f5737c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f5738d;

        public c(b bVar, boolean z, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z), Integer.valueOf(i2), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f5738d = bVar;
            this.f5735a = z;
            this.f5736b = i2;
            this.f5737c = str;
        }

        @Override // com.baidu.searchbox.v8engine.net.NetRequestCallback
        public void onFailed(int i2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) && this.f5735a) {
                b bVar = this.f5738d;
                int i3 = this.f5736b;
                bVar.q(i3, "预连接请求返回", "code=" + i2 + " msg=" + str);
            }
        }

        @Override // com.baidu.searchbox.v8engine.net.NetRequestCallback
        public void onSucceeded(String str, int i2, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, map) == null) && this.f5735a) {
                b bVar = this.f5738d;
                int i3 = this.f5736b;
                bVar.q(i3, "预连接请求返回", "code=" + i2 + " url=" + this.f5737c);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1597700776, "Lb/a/p0/a/h0/q/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1597700776, "Lb/a/p0/a/h0/q/b;");
                return;
            }
        }
        f5720g = k.f6397a;
        f5721h = null;
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
        this.f5722a = Collections.synchronizedList(new ArrayList());
        this.f5725d = new LinkedHashMap();
        this.f5726e = false;
        this.f5727f = new AtomicInteger(0);
    }

    public static b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f5721h == null) {
                synchronized (b.class) {
                    if (f5721h == null) {
                        f5721h = new b();
                    }
                }
            }
            return f5721h;
        }
        return (b) invokeV.objValue;
    }

    @WorkerThread
    public final void f(int i2, @NonNull String str, @NonNull String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, Boolean.valueOf(z)}) == null) {
            if (f5720g) {
                r0 = "doPrelink: " + str;
            }
            if (d.b()) {
                j(i2, str, str2, z);
                return;
            }
            b.a.p0.m.d.a aVar = new b.a.p0.m.d.a();
            aVar.f11034b = "HEAD";
            HttpRequestBuilder a2 = b.a.p0.m.e.b.a(aVar);
            a2.setHeader("Referer", h.d());
            aVar.f11033a = str;
            aVar.f11038f = true;
            aVar.f11039g = false;
            aVar.f11040h = true;
            b.a.p0.m.e.a.g().t(a2, aVar);
            HttpRequest build = a2.enableStat(true).build();
            if (z) {
                q(i2, "校验通过", "开始向 url=" + str + " 发送预连接 HEAD 请求");
            }
            build.executeStat(new C0244b(this, str, z, i2));
        }
    }

    public Set<String> h(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return Collections.emptySet();
            }
            Set<String> g2 = b.a.p0.a.b2.a.c.g(str);
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

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? !this.f5722a.isEmpty() : invokeV.booleanValue;
    }

    public final void j(int i2, @NonNull String str, @NonNull String str2, boolean z) {
        b.a.p0.a.h0.l.a O;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), str, str2, Boolean.valueOf(z)}) == null) && (O = g.M().O()) != null && (O.f() instanceof b.a.p0.a.l0.a)) {
            NetRequestParam.Builder builder = new NetRequestParam.Builder();
            builder.setUrl(str);
            builder.setMethod((byte) 2);
            NetRequestParam build = builder.build();
            build.setNetRequestCallback(new c(this, z, i2, str));
            b.a.p0.a.l0.a aVar = (b.a.p0.a.l0.a) O.f();
            if (aVar.n0() != null) {
                if (z) {
                    q(i2, "校验通过", "开始向 url=" + str + " 发送预连接 HEAD 请求");
                }
                aVar.n0().execute(build);
            }
        }
    }

    public synchronized void k(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            synchronized (this) {
                if (i()) {
                    if (this.f5727f.get() == this.f5722a.size()) {
                        if (f5720g) {
                            String str3 = "onBusinessRequest doRequest: " + str2;
                        }
                    } else if (this.f5723b == null || !this.f5723b.contains(str2)) {
                        String e2 = h.e(str2);
                        if (e2 != null && this.f5722a.contains(e2)) {
                            if (this.f5724c == null) {
                                this.f5724c = new ArrayMap();
                            } else if (this.f5724c.containsKey(e2)) {
                                return;
                            }
                            this.f5724c.put(e2, str);
                            if (f5720g) {
                                String str4 = "onBusinessRequest hit: " + str2;
                            }
                            q(this.f5724c.size() - 1, "业务方触发第一个同域名请求", "url=" + str2);
                            return;
                        }
                        if (f5720g) {
                            String str5 = "onBusinessRequest: miss tag " + str2;
                        }
                    }
                }
            }
        }
    }

    public synchronized void l(@NonNull String str, @NonNull HttpUrl httpUrl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, httpUrl) == null) {
            synchronized (this) {
                if (i()) {
                    if (this.f5727f.get() == this.f5722a.size()) {
                        if (f5720g) {
                            String str2 = "onBusinessRequest doRequest: " + httpUrl;
                        }
                        return;
                    }
                    String host = httpUrl.host();
                    if (host != null && this.f5722a.contains(host)) {
                        if (this.f5724c == null) {
                            this.f5724c = new ArrayMap();
                        } else if (this.f5724c.containsKey(host)) {
                            return;
                        }
                        this.f5724c.put(host, str);
                        if (f5720g) {
                            String str3 = "onBusinessRequest hit: " + httpUrl;
                        }
                        q(this.f5724c.size() - 1, "业务方触发第一个同域名请求", "url=" + httpUrl);
                        return;
                    }
                    if (f5720g) {
                        String str4 = "onBusinessRequest: miss tag " + httpUrl.toString();
                    }
                }
            }
        }
    }

    @WorkerThread
    public void m(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f5720g;
                return;
            }
            String e2 = h.e(str);
            if (TextUtils.isEmpty(e2)) {
                return;
            }
            f(-1, str, e2, false);
        }
    }

    public synchronized void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                boolean z = f5720g;
                if (f5721h == null) {
                    return;
                }
                f5721h = null;
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && f5720g) {
            this.f5722a.clear();
            this.f5724c = null;
        }
    }

    @AnyThread
    public synchronized void p(@Nullable String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, str, z) == null) {
            synchronized (this) {
                if (TextUtils.isEmpty(str)) {
                    boolean z2 = f5720g;
                } else if (!z && this.f5726e) {
                    boolean z3 = f5720g;
                } else {
                    this.f5726e = true;
                    ExecutorUtilsExt.postOnElastic(new a(this, str, z), "SwanPrelink", 0);
                }
            }
        }
    }

    public synchronized void q(@IntRange(from = -1) int i2, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048586, this, i2, str, str2) == null) {
            synchronized (this) {
                if (i2 >= 0) {
                    str = PreferencesUtil.LEFT_MOUNT + i2 + PreferencesUtil.RIGHT_MOUNT + str;
                }
                if (this.f5725d.containsKey(str)) {
                    return;
                }
                this.f5725d.put(str, str2);
                b.a.p0.a.q2.d.k.update((b.a.p0.a.q2.c<String>) s());
            }
        }
    }

    public synchronized void r(@NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, str2) == null) {
            synchronized (this) {
                q(-1, str, str2);
            }
        }
    }

    @NonNull
    public final synchronized String s() {
        InterceptResult invokeV;
        String sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            synchronized (this) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("========== prelink start ==========");
                sb2.append(Part.CRLF);
                for (Map.Entry<String, String> entry : this.f5725d.entrySet()) {
                    if (entry != null) {
                        sb2.append("----- ");
                        sb2.append(entry.getKey());
                        sb2.append(": ");
                        sb2.append(entry.getValue());
                        sb2.append("\r\n\r\n");
                    }
                }
                sb2.append("========== prelink end ==========");
                sb2.append(Part.CRLF);
                sb = sb2.toString();
            }
            return sb;
        }
        return (String) invokeV.objValue;
    }

    public void t(@NonNull String str, @NonNull String str2, @NonNull NetInfo netInfo) {
        HybridUbcFlow d2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048589, this, str, str2, netInfo) == null) && i() && this.f5724c != null && this.f5727f.get() != this.f5722a.size() && this.f5724c.containsValue(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("url=");
            sb.append(str2);
            sb.append("; ");
            if (netInfo.getSocket() != null) {
                sb.append("连接是否复用=");
                sb.append(netInfo.getSocket().mReused);
                sb.append("; ");
            }
            NetInfo.Timing timing = netInfo.getTiming();
            if (timing != null) {
                sb.append("DNS耗时=");
                sb.append(timing.mDns / 1000);
                sb.append("ms; ");
                sb.append("连接耗时=");
                sb.append(timing.mConnect / 1000);
                sb.append("ms; ");
            }
            q(this.f5727f.incrementAndGet() - 1, "业务方第一个同域名请求返回", sb.toString());
            if (this.f5727f.get() != 1 || (d2 = b.a.p0.a.r1.h.d("startup")) == null || timing == null) {
                return;
            }
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("request_network_start");
            ubcFlowEvent.h(0L);
            d2.C(ubcFlowEvent);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("request_network_conn");
            ubcFlowEvent2.h(timing.mConnect / 1000);
            d2.C(ubcFlowEvent2);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("request_dns_start");
            ubcFlowEvent3.h(0L);
            d2.C(ubcFlowEvent3);
            UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("request_dns_end");
            ubcFlowEvent4.h(timing.mDns / 1000);
            d2.C(ubcFlowEvent4);
        }
    }

    public void u(@NonNull String str, @NonNull HttpUrl httpUrl, NetworkStatRecord networkStatRecord) {
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048590, this, str, httpUrl, networkStatRecord) == null) || !i() || networkStatRecord == null || this.f5724c == null || this.f5727f.get() == this.f5722a.size()) {
            return;
        }
        synchronized (b.class) {
            if (this.f5724c.containsValue(str)) {
                this.f5727f.incrementAndGet();
                long j2 = networkStatRecord.dnsEndTs;
                long j3 = networkStatRecord.dnsStartTs;
                long j4 = networkStatRecord.connTs;
                long j5 = networkStatRecord.startTs;
                long j6 = j2 - j3;
                long j7 = (j4 - j5) - j6;
                if (f5720g) {
                    StringBuilder sb = new StringBuilder();
                    j = j2;
                    sb.append("tryRecordNetworkStat: ");
                    sb.append(httpUrl);
                    sb.toString();
                    String str2 = "tryRecordNetworkStat: isConnReused: " + networkStatRecord.isConnReused;
                    String str3 = "tryRecordNetworkStat: dnsTime: " + j6 + " connTime: " + j7;
                } else {
                    j = j2;
                }
                q(this.f5727f.get() - 1, "业务方第一个同域名请求返回", " 连接是否复用=" + networkStatRecord.isConnReused + " dns解析时长=" + j6 + "ms 网络连接时长=" + j7 + "ms url=" + httpUrl);
                if (this.f5727f.get() <= 1) {
                    HybridUbcFlow p = b.a.p0.a.r1.h.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("request_network_start");
                    ubcFlowEvent.h(j5);
                    p.C(ubcFlowEvent);
                    UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("request_network_conn");
                    ubcFlowEvent2.h(j4);
                    p.C(ubcFlowEvent2);
                    UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("request_dns_start");
                    ubcFlowEvent3.h(j3);
                    p.C(ubcFlowEvent3);
                    UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("request_dns_end");
                    ubcFlowEvent4.h(j);
                    p.C(ubcFlowEvent4);
                    UbcFlowEvent ubcFlowEvent5 = new UbcFlowEvent("request_network_response");
                    ubcFlowEvent5.h(networkStatRecord.responseTs);
                    p.C(ubcFlowEvent5);
                    UbcFlowEvent ubcFlowEvent6 = new UbcFlowEvent("request_send_header");
                    ubcFlowEvent6.h(networkStatRecord.sendHeaderTs);
                    p.C(ubcFlowEvent6);
                    UbcFlowEvent ubcFlowEvent7 = new UbcFlowEvent("request_receive_header");
                    ubcFlowEvent7.h(networkStatRecord.receiveHeaderTs);
                    p.C(ubcFlowEvent7);
                    p.A("connResued", String.valueOf(networkStatRecord.isConnReused));
                }
            }
        }
    }
}
