package c.g;

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
import com.fun.p0;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class r0 extends o0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f29343f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f29344b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f29345c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<d> f29346d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29347e;

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(r0 r0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r0Var, looper};
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
            this.a = r0Var;
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
                        int h2 = a0.h();
                        int a = a0.a();
                        int i4 = (i3 - h2) - a;
                        LogPrinter.d("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i3), Integer.valueOf(h2), Integer.valueOf(a), Integer.valueOf(i4));
                        if (i4 > 0) {
                            a0.e("key_rpt_mis_c", i4);
                            return;
                        }
                        return;
                    }
                    LogPrinter.v("turn on report switch", new Object[0]);
                    this.a.f29347e = true;
                }
                r0.e(this.a);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements p0.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ r0 a;

        public b(r0 r0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = r0Var;
        }

        @Override // com.fun.p0.b
        public void a(@Nullable NetworkInfo networkInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkInfo) == null) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    this.a.f29345c.removeMessages(1);
                    this.a.f29345c.sendEmptyMessage(1);
                    return;
                }
                this.a.f29345c.removeMessages(1);
            }
        }
    }

    /* loaded from: classes9.dex */
    public static class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final JSONArray f29348b;

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
            this.f29348b = new JSONArray();
            a(eVar);
        }

        @Override // c.g.r0.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (a()) {
                    return this;
                }
                if (dVar instanceof e) {
                    e eVar = (e) dVar;
                    this.f29348b.put(eVar.f29351d);
                    eVar.f29351d = null;
                    return this;
                } else if (!(dVar instanceof c)) {
                    throw new IllegalArgumentException("Unknown Event type:" + dVar);
                } else {
                    c cVar = (c) dVar;
                    while (!a() && cVar.f29348b.length() > 0) {
                        this.f29348b.put(cVar.f29348b.remove(0));
                    }
                    return this;
                }
            }
            return (d) invokeL.objValue;
        }

        @Override // c.g.r0.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29348b.length() >= 10 : invokeV.booleanValue;
        }

        @Override // c.g.r0.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.v("ArrayEvent reported succeed with len:%d", Integer.valueOf(this.f29348b.length()));
                a0.e("key_rpt_suc_c", a0.h() + this.f29348b.length());
            }
        }

        @Override // c.g.r0.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f29348b : (JSONArray) invokeV.objValue;
        }

        @Override // c.g.r0.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i2 = 0;
                while (this.f29348b.length() > 0 && i2 < 1) {
                    this.f29348b.remove(0);
                    i2++;
                }
                a0.e("key_rpt_fai_c", a0.a() + i2);
                LogPrinter.v("cut %d datas from ArrayEvent", Integer.valueOf(i2));
            }
        }

        @Override // c.g.r0.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29348b.length() <= 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        d a(d dVar);

        boolean a();

        void b();

        long c();

        JSONArray d();

        boolean isEmpty();
    }

    /* loaded from: classes9.dex */
    public static class e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final String f29349b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f29350c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f29351d;

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
            this.f29349b = str;
            this.f29350c = jSONObject;
            this.f29351d = m0.b(str, jSONObject, System.currentTimeMillis());
            if (FunAdSdk.isLogEnabled()) {
                LogPrinter.v("report Event:" + this, new Object[0]);
            }
        }

        @Override // c.g.r0.d
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

        @Override // c.g.r0.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.g.r0.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                LogPrinter.v("JSONEvent reported succeed", new Object[0]);
                if (this.f29351d != null) {
                    a0.e("key_rpt_suc_c", a0.h() + 1);
                }
            }
        }

        @Override // c.g.r0.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f29351d == null) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.f29351d);
                return jSONArray;
            }
            return (JSONArray) invokeV.objValue;
        }

        @Override // c.g.r0.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                LogPrinter.v("give up report JSONEvent", new Object[0]);
                this.f29351d = null;
                a0.e("key_rpt_fai_c", a0.a() + 1);
            }
        }

        @Override // c.g.r0.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f29351d == null : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return "{key='" + this.f29349b + ExtendedMessageFormat.QUOTE + ", content=" + this.f29350c + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class f implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

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

        @Override // c.g.r0.d
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LogPrinter.v("RetryEvent reported failed with retryCount:%d", Integer.valueOf(this.a));
                int i2 = this.a;
                int i3 = i2 + 1;
                this.a = i3;
                if (i2 >= 2) {
                    e();
                    this.a = 0;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1579645475, "Lc/g/r0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1579645475, "Lc/g/r0;");
                return;
            }
        }
        f29343f = !r0.class.desiredAssertionStatus();
    }

    public r0(String str) {
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
        this.f29346d = new LinkedList<>();
        this.f29347e = true;
        this.f29344b = str;
        HandlerThread handlerThread = new HandlerThread("reporter2");
        handlerThread.start();
        a aVar = new a(this, handlerThread.getLooper());
        this.f29345c = aVar;
        aVar.obtainMessage(3, a0.g(), 0).sendToTarget();
        com.fun.p0.b(new b(this));
    }

    public static void e(r0 r0Var) {
        d pollFirst;
        JSONArray jSONArray;
        d peekFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, r0Var) == null) {
            while (r0Var.f29347e) {
                synchronized (r0Var.f29346d) {
                    pollFirst = r0Var.f29346d.pollFirst();
                    if (pollFirst == null) {
                        return;
                    }
                    while (!pollFirst.a() && !r0Var.f29346d.isEmpty() && (peekFirst = r0Var.f29346d.peekFirst()) != null) {
                        pollFirst = pollFirst.a(peekFirst);
                        if (peekFirst.isEmpty()) {
                            r0Var.f29346d.removeFirst();
                        } else if (!f29343f && !pollFirst.a()) {
                            throw new AssertionError();
                        }
                    }
                }
                if (r0Var.g(pollFirst.d())) {
                    pollFirst.b();
                    int a2 = a0.a();
                    int f2 = a0.f();
                    if (a2 > 0 || f2 > 0) {
                        int h2 = a0.h();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("fai", a2);
                            jSONObject.put("suc", h2);
                            jSONObject.put("mis", f2);
                        } catch (JSONException unused) {
                        }
                        e eVar = new e("k_rpt", jSONObject);
                        if (eVar.f29351d == null) {
                            jSONArray = null;
                        } else {
                            jSONArray = new JSONArray();
                            jSONArray.put(eVar.f29351d);
                        }
                        if (r0Var.g(jSONArray)) {
                            a0.d(a2, h2, f2);
                        }
                    }
                } else {
                    long c2 = pollFirst.c();
                    if (!pollFirst.isEmpty()) {
                        synchronized (r0Var.f29346d) {
                            r0Var.f29346d.addFirst(pollFirst);
                        }
                    }
                    if (c2 > 0) {
                        LogPrinter.v("turn off report switch, reScheduleReport delay:%dms", Long.valueOf(c2));
                        r0Var.f29347e = false;
                        if (!r0Var.f29345c.hasMessages(2)) {
                            r0Var.f29345c.sendEmptyMessageDelayed(2, c2);
                        }
                    }
                }
            }
        }
    }

    @Override // c.g.o0
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

    @Override // c.g.o0
    public void c(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) {
            d(str, new JSONObject(map));
        }
    }

    @Override // c.g.o0
    public void d(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) {
            e eVar = new e(str, jSONObject);
            a0.j();
            synchronized (this.f29346d) {
                this.f29346d.add(eVar);
            }
            NetworkInfo networkInfo = com.fun.p0.a;
            boolean z = false;
            if (!(networkInfo != null && networkInfo.isConnected()) || this.f29345c.hasMessages(1)) {
                return;
            }
            Handler handler = this.f29345c;
            long j2 = a0.f29051b.getLong("key_flt", 0L);
            if (j2 > 0 && System.currentTimeMillis() - j2 >= 86400000) {
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
                p0Var = new j0(this.f29344b, new n0(jSONArray.toString(), f0.f29292b), true).a();
            } catch (IOException e2) {
                LogPrinter.e(e2);
                p0Var = null;
            }
            return p0Var != null && p0Var.a == 200;
        }
        return invokeL.booleanValue;
    }
}
