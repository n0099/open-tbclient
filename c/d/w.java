package c.d;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.internal.api.http.ContentType;
import com.fun.ad.sdk.internal.api.http.PostRequest;
import com.fun.ad.sdk.internal.api.http.RequestParams;
import com.fun.ad.sdk.internal.api.http.Response;
import com.fun.ad.sdk.internal.api.reporter.Reporter;
import com.fun.ad.sdk.internal.api.utils.HostAppInfo;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.i0;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class w implements Reporter {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f23236f;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f23237b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f23238c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<d> f23239d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f23240e;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w wVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wVar;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return;
                        }
                        int i2 = message.arg1;
                        int h2 = o.h();
                        int a = o.a();
                        int i3 = (i2 - h2) - a;
                        LogPrinter.d("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i2), Integer.valueOf(h2), Integer.valueOf(a), Integer.valueOf(i3));
                        if (i3 > 0) {
                            o.e("key_rpt_mis_c", i3);
                            return;
                        }
                        return;
                    }
                    LogPrinter.v("turn on report switch", new Object[0]);
                    this.a.f23240e = true;
                }
                w.a(this.a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements i0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w a;

        public b(w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wVar;
        }

        @Override // com.fun.i0.b
        public void onActiveNetworkInfo(@Nullable NetworkInfo networkInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkInfo) == null) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    this.a.f23238c.removeMessages(1);
                    this.a.f23238c.sendEmptyMessage(1);
                    return;
                }
                this.a.f23238c.removeMessages(1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final JSONArray f23241b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ w f23242c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(w wVar, e eVar) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23242c = wVar;
            this.f23241b = new JSONArray();
            a(eVar);
        }

        @Override // c.d.w.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (a()) {
                    return this;
                }
                if (dVar instanceof e) {
                    e eVar = (e) dVar;
                    this.f23241b.put(eVar.f23245d);
                    eVar.f23245d = null;
                    return this;
                } else if (!(dVar instanceof c)) {
                    throw new IllegalArgumentException("Unknown Event type:" + dVar);
                } else {
                    c cVar = (c) dVar;
                    while (!a() && cVar.f23241b.length() > 0) {
                        this.f23241b.put(cVar.f23241b.remove(0));
                    }
                    return this;
                }
            }
            return (d) invokeL.objValue;
        }

        @Override // c.d.w.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f23241b.length() >= 10 : invokeV.booleanValue;
        }

        @Override // c.d.w.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.v("ArrayEvent reported succeed with len:%d", Integer.valueOf(this.f23241b.length()));
                if (this.f23242c.f23237b) {
                    o.e("key_rpt_suc_c", o.h() + this.f23241b.length());
                }
            }
        }

        @Override // c.d.w.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f23241b : (JSONArray) invokeV.objValue;
        }

        @Override // c.d.w.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i = 0;
                while (this.f23241b.length() > 0 && i < 1) {
                    this.f23241b.remove(0);
                    i++;
                }
                if (this.f23242c.f23237b) {
                    o.e("key_rpt_fai_c", o.a() + i);
                }
                LogPrinter.v("cut %d datas from ArrayEvent", Integer.valueOf(i));
            }
        }

        @Override // c.d.w.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23241b.length() <= 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        d a(d dVar);

        boolean a();

        void b();

        long c();

        JSONArray d();

        boolean isEmpty();
    }

    /* loaded from: classes3.dex */
    public class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final String f23243b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f23244c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f23245d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ w f23246e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(w wVar, String str, JSONObject jSONObject) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wVar, str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23246e = wVar;
            this.f23243b = str;
            this.f23244c = jSONObject;
            this.f23245d = HostAppInfo.buildReportJson(str, jSONObject, System.currentTimeMillis());
            if (FunAdSdk.isLogEnabled()) {
                LogPrinter.v("report Event:" + this, new Object[0]);
            }
        }

        @Override // c.d.w.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (dVar instanceof e) {
                    c cVar = new c(this.f23246e, this);
                    cVar.a(dVar);
                    return cVar;
                } else if (dVar instanceof c) {
                    c cVar2 = (c) dVar;
                    cVar2.a(this);
                    return cVar2;
                } else {
                    throw new IllegalArgumentException("Unknown Event type:" + dVar);
                }
            }
            return (d) invokeL.objValue;
        }

        @Override // c.d.w.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.d.w.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.v("JSONEvent reported succeed", new Object[0]);
                if (this.f23245d == null || !this.f23246e.f23237b) {
                    return;
                }
                o.e("key_rpt_suc_c", o.h() + 1);
            }
        }

        @Override // c.d.w.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f23245d == null) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.f23245d);
                return jSONArray;
            }
            return (JSONArray) invokeV.objValue;
        }

        @Override // c.d.w.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                LogPrinter.v("give up report JSONEvent", new Object[0]);
                this.f23245d = null;
                if (this.f23246e.f23237b) {
                    o.e("key_rpt_fai_c", o.a() + 1);
                }
            }
        }

        @Override // c.d.w.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f23245d == null : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return "{key='" + this.f23243b + "', content=" + this.f23244c + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class f implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        @Override // c.d.w.d
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogPrinter.v("RetryEvent reported failed with retryCount:%d", Integer.valueOf(this.a));
                int i = this.a;
                int i2 = i + 1;
                this.a = i2;
                if (i >= 2) {
                    e();
                    this.a = 0;
                    return 0L;
                }
                return i2 * 1000;
            }
            return invokeV.longValue;
        }

        public abstract void e();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1611522471, "Lc/d/w;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1611522471, "Lc/d/w;");
                return;
            }
        }
        f23236f = !w.class.desiredAssertionStatus();
    }

    public w(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23239d = new LinkedList<>();
        this.f23240e = true;
        this.a = str;
        this.f23237b = z;
        HandlerThread handlerThread = new HandlerThread("reporter2");
        handlerThread.start();
        a aVar = new a(this, handlerThread.getLooper());
        this.f23238c = aVar;
        if (z) {
            aVar.obtainMessage(3, o.g(), 0).sendToTarget();
        }
        com.fun.i0.b(new b(this));
    }

    public static void a(w wVar) {
        d pollFirst;
        JSONArray jSONArray;
        d peekFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, wVar) == null) {
            while (wVar.f23240e) {
                synchronized (wVar.f23239d) {
                    pollFirst = wVar.f23239d.pollFirst();
                    if (pollFirst == null) {
                        return;
                    }
                    while (!pollFirst.a() && !wVar.f23239d.isEmpty() && (peekFirst = wVar.f23239d.peekFirst()) != null) {
                        pollFirst = pollFirst.a(peekFirst);
                        if (peekFirst.isEmpty()) {
                            wVar.f23239d.removeFirst();
                        } else if (!f23236f && !pollFirst.a()) {
                            throw new AssertionError();
                        }
                    }
                }
                if (wVar.c(pollFirst.d())) {
                    pollFirst.b();
                    if (wVar.f23237b) {
                        int a2 = o.a();
                        int f2 = o.f();
                        if (a2 > 0 || f2 > 0) {
                            int h2 = o.h();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("fai", a2);
                                jSONObject.put("suc", h2);
                                jSONObject.put("mis", f2);
                            } catch (JSONException unused) {
                            }
                            e eVar = new e(wVar, "k_rpt", jSONObject);
                            if (eVar.f23245d == null) {
                                jSONArray = null;
                            } else {
                                jSONArray = new JSONArray();
                                jSONArray.put(eVar.f23245d);
                            }
                            if (wVar.c(jSONArray)) {
                                o.d(a2, h2, f2);
                            }
                        }
                    }
                } else {
                    long c2 = pollFirst.c();
                    if (!pollFirst.isEmpty()) {
                        synchronized (wVar.f23239d) {
                            wVar.f23239d.addFirst(pollFirst);
                        }
                    }
                    if (c2 > 0) {
                        LogPrinter.v("turn off report switch, reScheduleReport delay:%dms", Long.valueOf(c2));
                        wVar.f23240e = false;
                        if (!wVar.f23238c.hasMessages(2)) {
                            wVar.f23238c.sendEmptyMessageDelayed(2, c2);
                        }
                    }
                }
            }
        }
    }

    public final boolean c(JSONArray jSONArray) {
        InterceptResult invokeL;
        Response response;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONArray)) == null) {
            try {
                response = new PostRequest(this.a, new RequestParams(jSONArray.toString(), ContentType.JSON), true).perform();
            } catch (IOException e2) {
                LogPrinter.e(e2);
                response = null;
            }
            return response != null && response.getResponseCode() == 200;
        }
        return invokeL.booleanValue;
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, obj) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str2, obj);
            } catch (JSONException unused) {
            }
            logEvent(str, jSONObject);
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, map) == null) {
            logEvent(str, new JSONObject(map));
        }
    }

    @Override // com.fun.ad.sdk.internal.api.reporter.Reporter
    public void logEvent(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, jSONObject) == null) {
            e eVar = new e(this, str, jSONObject);
            if (this.f23237b) {
                o.j();
            }
            synchronized (this.f23239d) {
                this.f23239d.add(eVar);
            }
            NetworkInfo networkInfo = com.fun.i0.a;
            boolean z = false;
            if (!(networkInfo != null && networkInfo.isConnected()) || this.f23238c.hasMessages(1)) {
                return;
            }
            Handler handler = this.f23238c;
            long j = o.f23222b.getLong("key_flt", 0L);
            if (j > 0 && System.currentTimeMillis() - j >= 86400000) {
                z = true;
            }
            handler.sendEmptyMessageDelayed(1, z ? 5000L : 0L);
        }
    }
}
