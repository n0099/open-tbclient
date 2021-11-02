package b.g;

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
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import com.fun.m0;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class m0 extends i0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ boolean f31202g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final String f31203c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f31204d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedList<d> f31205e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f31206f;

    /* loaded from: classes6.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f31207a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(m0 m0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m0Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31207a = m0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i2 = message.what;
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return;
                        }
                        int i3 = message.arg1;
                        int g2 = v.g();
                        int a2 = v.a();
                        int i4 = (i3 - g2) - a2;
                        LogPrinter.d("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i3), Integer.valueOf(g2), Integer.valueOf(a2), Integer.valueOf(i4));
                        if (i4 > 0) {
                            v.d("key_rpt_mis_c", i4);
                            return;
                        }
                        return;
                    }
                    LogPrinter.v("turn on report switch", new Object[0]);
                    this.f31207a.f31206f = true;
                }
                m0.e(this.f31207a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements m0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m0 f31208a;

        public b(m0 m0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31208a = m0Var;
        }

        @Override // com.fun.m0.b
        public void a(@Nullable NetworkInfo networkInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkInfo) == null) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    this.f31208a.f31204d.removeMessages(1);
                    this.f31208a.f31204d.sendEmptyMessage(1);
                    return;
                }
                this.f31208a.f31204d.removeMessages(1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final JSONArray f31209b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31209b = new JSONArray();
            a(eVar);
        }

        @Override // b.g.m0.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (a()) {
                    return this;
                }
                if (dVar instanceof e) {
                    e eVar = (e) dVar;
                    this.f31209b.put(eVar.f31212d);
                    eVar.f31212d = null;
                    return this;
                } else if (!(dVar instanceof c)) {
                    throw new IllegalArgumentException("Unknown Event type:" + dVar);
                } else {
                    c cVar = (c) dVar;
                    while (!a() && cVar.f31209b.length() > 0) {
                        this.f31209b.put(cVar.f31209b.remove(0));
                    }
                    return this;
                }
            }
            return (d) invokeL.objValue;
        }

        @Override // b.g.m0.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f31209b.length() >= 10 : invokeV.booleanValue;
        }

        @Override // b.g.m0.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.v("ArrayEvent reported succeed with len:%d", Integer.valueOf(this.f31209b.length()));
                v.d("key_rpt_suc_c", v.g() + this.f31209b.length());
            }
        }

        @Override // b.g.m0.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31209b : (JSONArray) invokeV.objValue;
        }

        @Override // b.g.m0.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i2 = 0;
                while (this.f31209b.length() > 0 && i2 < 1) {
                    this.f31209b.remove(0);
                    i2++;
                }
                v.d("key_rpt_fai_c", v.a() + i2);
                LogPrinter.v("cut %d datas from ArrayEvent", Integer.valueOf(i2));
            }
        }

        @Override // b.g.m0.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31209b.length() <= 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface d {
        d a(d dVar);

        boolean a();

        void b();

        long c();

        JSONArray d();

        boolean isEmpty();
    }

    /* loaded from: classes6.dex */
    public static class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final String f31210b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f31211c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f31212d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, JSONObject jSONObject) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((a) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31210b = str;
            this.f31211c = jSONObject;
            this.f31212d = g0.b(str, jSONObject, System.currentTimeMillis());
            if (FunAdSdk.isLogEnabled()) {
                LogPrinter.v("report Event:" + this, new Object[0]);
            }
        }

        @Override // b.g.m0.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (dVar instanceof e) {
                    c cVar = new c(this);
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

        @Override // b.g.m0.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // b.g.m0.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.v("JSONEvent reported succeed", new Object[0]);
                if (this.f31212d != null) {
                    v.d("key_rpt_suc_c", v.g() + 1);
                }
            }
        }

        @Override // b.g.m0.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f31212d == null) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.f31212d);
                return jSONArray;
            }
            return (JSONArray) invokeV.objValue;
        }

        @Override // b.g.m0.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                LogPrinter.v("give up report JSONEvent", new Object[0]);
                this.f31212d = null;
                v.d("key_rpt_fai_c", v.a() + 1);
            }
        }

        @Override // b.g.m0.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f31212d == null : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return "{key='" + this.f31210b + ExtendedMessageFormat.QUOTE + ", content=" + this.f31211c + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class f implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f31213a;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ f(a aVar) {
            this();
        }

        @Override // b.g.m0.d
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogPrinter.v("RetryEvent reported failed with retryCount:%d", Integer.valueOf(this.f31213a));
                int i2 = this.f31213a;
                int i3 = i2 + 1;
                this.f31213a = i3;
                if (i2 >= 2) {
                    e();
                    this.f31213a = 0;
                    return 0L;
                }
                return i3 * 1000;
            }
            return invokeV.longValue;
        }

        public abstract void e();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1827813335, "Lb/g/m0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1827813335, "Lb/g/m0;");
                return;
            }
        }
        f31202g = !m0.class.desiredAssertionStatus();
    }

    public m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31205e = new LinkedList<>();
        this.f31206f = true;
        this.f31203c = str;
        HandlerThread handlerThread = new HandlerThread("reporter2");
        handlerThread.start();
        a aVar = new a(this, handlerThread.getLooper());
        this.f31204d = aVar;
        aVar.obtainMessage(3, v.f(), 0).sendToTarget();
        com.fun.m0.b(new b(this));
    }

    public static void e(m0 m0Var) {
        d pollFirst;
        JSONArray jSONArray;
        d peekFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, m0Var) == null) {
            while (m0Var.f31206f) {
                synchronized (m0Var.f31205e) {
                    pollFirst = m0Var.f31205e.pollFirst();
                    if (pollFirst == null) {
                        return;
                    }
                    while (!pollFirst.a() && !m0Var.f31205e.isEmpty() && (peekFirst = m0Var.f31205e.peekFirst()) != null) {
                        pollFirst = pollFirst.a(peekFirst);
                        if (peekFirst.isEmpty()) {
                            m0Var.f31205e.removeFirst();
                        } else if (!f31202g && !pollFirst.a()) {
                            throw new AssertionError();
                        }
                    }
                }
                if (m0Var.g(pollFirst.d())) {
                    pollFirst.b();
                    int a2 = v.a();
                    int e2 = v.e();
                    if (a2 > 0 || e2 > 0) {
                        int g2 = v.g();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("fai", a2);
                            jSONObject.put("suc", g2);
                            jSONObject.put("mis", e2);
                        } catch (JSONException unused) {
                        }
                        e eVar = new e("k_rpt", jSONObject);
                        if (eVar.f31212d == null) {
                            jSONArray = null;
                        } else {
                            jSONArray = new JSONArray();
                            jSONArray.put(eVar.f31212d);
                        }
                        if (m0Var.g(jSONArray)) {
                            v.c(a2, g2, e2);
                        }
                    }
                } else {
                    long c2 = pollFirst.c();
                    if (!pollFirst.isEmpty()) {
                        synchronized (m0Var.f31205e) {
                            m0Var.f31205e.addFirst(pollFirst);
                        }
                    }
                    if (c2 > 0) {
                        LogPrinter.v("turn off report switch, reScheduleReport delay:%dms", Long.valueOf(c2));
                        m0Var.f31206f = false;
                        if (!m0Var.f31204d.hasMessages(2)) {
                            m0Var.f31204d.sendEmptyMessageDelayed(2, c2);
                        }
                    }
                }
            }
        }
    }

    @Override // b.g.i0
    public void b(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str2, obj);
            } catch (JSONException unused) {
            }
            d(str, jSONObject);
        }
    }

    @Override // b.g.i0
    public void c(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) {
            d(str, new JSONObject(map));
        }
    }

    @Override // b.g.i0
    public void d(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) {
            e eVar = new e(str, jSONObject);
            v.h();
            synchronized (this.f31205e) {
                this.f31205e.add(eVar);
            }
            NetworkInfo networkInfo = com.fun.m0.f62865a;
            boolean z = false;
            if (!(networkInfo != null && networkInfo.isConnected()) || this.f31204d.hasMessages(1)) {
                return;
            }
            Handler handler = this.f31204d;
            long j = v.f31248b.getLong("key_flt", 0L);
            if (j > 0 && System.currentTimeMillis() - j >= 86400000) {
                z = true;
            }
            handler.sendEmptyMessageDelayed(1, z ? 5000L : 0L);
        }
    }

    public final boolean g(JSONArray jSONArray) {
        InterceptResult invokeL;
        p0 p0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            try {
                p0Var = new j0(this.f31203c, new n0(jSONArray.toString(), e0.f31136b), true).a();
            } catch (IOException e2) {
                LogPrinter.e(e2);
                p0Var = null;
            }
            return p0Var != null && p0Var.f31224a == 200;
        }
        return invokeL.booleanValue;
    }
}
