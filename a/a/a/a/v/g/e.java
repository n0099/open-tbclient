package a.a.a.a.v.g;

import a.a.a.a.v.f;
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
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends a.a.a.a.v.g.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f1414f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f1415b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f1416c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<d> f1417d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1418e;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f1419a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, looper};
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
            this.f1419a = eVar;
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
                        int d2 = a.a.a.a.v.b.d();
                        int a2 = a.a.a.a.v.b.a();
                        int i4 = (i3 - d2) - a2;
                        a.a.a.a.v.d.a("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i3), Integer.valueOf(d2), Integer.valueOf(a2), Integer.valueOf(i4));
                        if (i4 > 0) {
                            a.a.a.a.v.b.a("key_rpt_mis_c", i4);
                            return;
                        }
                        return;
                    }
                    a.a.a.a.v.d.c("turn on report switch", new Object[0]);
                    this.f1419a.f1418e = true;
                }
                e.a(this.f1419a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f1420a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1420a = eVar;
        }

        @Override // a.a.a.a.v.f.b
        public void a(@Nullable NetworkInfo networkInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkInfo) == null) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    this.f1420a.f1416c.removeMessages(1);
                    this.f1420a.f1416c.sendEmptyMessage(1);
                    return;
                }
                this.f1420a.f1416c.removeMessages(1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final JSONArray f1421b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C0005e c0005e) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0005e};
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
            this.f1421b = new JSONArray();
            a(c0005e);
        }

        @Override // a.a.a.a.v.g.e.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (a()) {
                    return this;
                }
                if (dVar instanceof C0005e) {
                    C0005e c0005e = (C0005e) dVar;
                    this.f1421b.put(c0005e.f1424d);
                    c0005e.f1424d = null;
                    return this;
                } else if (!(dVar instanceof c)) {
                    throw new IllegalArgumentException("Unknown Event type:" + dVar);
                } else {
                    c cVar = (c) dVar;
                    while (!a() && cVar.f1421b.length() > 0) {
                        this.f1421b.put(cVar.f1421b.remove(0));
                    }
                    return this;
                }
            }
            return (d) invokeL.objValue;
        }

        @Override // a.a.a.a.v.g.e.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1421b.length() >= 10 : invokeV.booleanValue;
        }

        @Override // a.a.a.a.v.g.e.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.v.d.c("ArrayEvent reported succeed with len:%d", Integer.valueOf(this.f1421b.length()));
                a.a.a.a.v.b.a("key_rpt_suc_c", a.a.a.a.v.b.d() + this.f1421b.length());
            }
        }

        @Override // a.a.a.a.v.g.e.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1421b : (JSONArray) invokeV.objValue;
        }

        @Override // a.a.a.a.v.g.e.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i2 = 0;
                while (this.f1421b.length() > 0 && i2 < 1) {
                    this.f1421b.remove(0);
                    i2++;
                }
                a.a.a.a.v.b.a("key_rpt_fai_c", a.a.a.a.v.b.a() + i2);
                a.a.a.a.v.d.c("cut %d datas from ArrayEvent", Integer.valueOf(i2));
            }
        }

        @Override // a.a.a.a.v.g.e.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1421b.length() <= 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        d a(d dVar);

        boolean a();

        void b();

        long c();

        JSONArray d();

        boolean isEmpty();
    }

    /* renamed from: a.a.a.a.v.g.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0005e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final String f1422b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f1423c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f1424d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0005e(String str, JSONObject jSONObject) {
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
            this.f1422b = str;
            this.f1423c = jSONObject;
            this.f1424d = a.a.a.a.v.g.c.a(str, jSONObject, System.currentTimeMillis());
            if (FunAdSdk.isLogEnabled()) {
                a.a.a.a.v.d.c("report Event:" + this, new Object[0]);
            }
        }

        @Override // a.a.a.a.v.g.e.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (dVar instanceof C0005e) {
                    return new c(this).a(dVar);
                }
                if (dVar instanceof c) {
                    return ((c) dVar).a(this);
                }
                throw new IllegalArgumentException("Unknown Event type:" + dVar);
            }
            return (d) invokeL.objValue;
        }

        @Override // a.a.a.a.v.g.e.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // a.a.a.a.v.g.e.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                a.a.a.a.v.d.c("JSONEvent reported succeed", new Object[0]);
                if (this.f1424d != null) {
                    a.a.a.a.v.b.a("key_rpt_suc_c", a.a.a.a.v.b.d() + 1);
                }
            }
        }

        @Override // a.a.a.a.v.g.e.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f1424d == null) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.f1424d);
                return jSONArray;
            }
            return (JSONArray) invokeV.objValue;
        }

        @Override // a.a.a.a.v.g.e.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                a.a.a.a.v.d.c("give up report JSONEvent", new Object[0]);
                this.f1424d = null;
                a.a.a.a.v.b.a("key_rpt_fai_c", a.a.a.a.v.b.a() + 1);
            }
        }

        @Override // a.a.a.a.v.g.e.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1424d == null : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return "{key='" + this.f1422b + "', content=" + this.f1423c + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f1425a;

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

        @Override // a.a.a.a.v.g.e.d
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                a.a.a.a.v.d.c("RetryEvent reported failed with retryCount:%d", Integer.valueOf(this.f1425a));
                int i2 = this.f1425a;
                int i3 = i2 + 1;
                this.f1425a = i3;
                if (i2 >= 2) {
                    e();
                    this.f1425a = 0;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-207325925, "La/a/a/a/v/g/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-207325925, "La/a/a/a/v/g/e;");
                return;
            }
        }
        f1414f = !e.class.desiredAssertionStatus();
    }

    public e(String str) {
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
        this.f1417d = new LinkedList<>();
        this.f1418e = true;
        this.f1415b = str;
        HandlerThread handlerThread = new HandlerThread("reporter2");
        handlerThread.start();
        this.f1416c = new a(this, handlerThread.getLooper());
        this.f1416c.obtainMessage(3, a.a.a.a.v.b.c(), 0).sendToTarget();
        a.a.a.a.v.f.a(new b(this));
    }

    public static void a(e eVar) {
        d pollFirst;
        JSONArray jSONArray;
        d peekFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, eVar) == null) {
            while (eVar.f1418e) {
                synchronized (eVar.f1417d) {
                    pollFirst = eVar.f1417d.pollFirst();
                    if (pollFirst == null) {
                        return;
                    }
                    while (!pollFirst.a() && !eVar.f1417d.isEmpty() && (peekFirst = eVar.f1417d.peekFirst()) != null) {
                        pollFirst = pollFirst.a(peekFirst);
                        if (peekFirst.isEmpty()) {
                            eVar.f1417d.removeFirst();
                        } else if (!f1414f && !pollFirst.a()) {
                            throw new AssertionError();
                        }
                    }
                }
                if (eVar.a(pollFirst.d())) {
                    pollFirst.b();
                    int a2 = a.a.a.a.v.b.a();
                    int b2 = a.a.a.a.v.b.b();
                    if (a2 > 0 || b2 > 0) {
                        int d2 = a.a.a.a.v.b.d();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("fai", a2);
                            jSONObject.put("suc", d2);
                            jSONObject.put("mis", b2);
                        } catch (JSONException unused) {
                        }
                        C0005e c0005e = new C0005e("k_rpt", jSONObject);
                        if (c0005e.f1424d == null) {
                            jSONArray = null;
                        } else {
                            jSONArray = new JSONArray();
                            jSONArray.put(c0005e.f1424d);
                        }
                        if (eVar.a(jSONArray)) {
                            a.a.a.a.v.b.a(a2, d2, b2);
                        }
                    }
                } else {
                    long c2 = pollFirst.c();
                    if (!pollFirst.isEmpty()) {
                        synchronized (eVar.f1417d) {
                            eVar.f1417d.addFirst(pollFirst);
                        }
                    }
                    if (c2 > 0) {
                        a.a.a.a.v.d.c("turn off report switch, reScheduleReport delay:%dms", Long.valueOf(c2));
                        eVar.f1418e = false;
                        if (!eVar.f1416c.hasMessages(2)) {
                            eVar.f1416c.sendEmptyMessageDelayed(2, c2);
                        }
                    }
                }
            }
        }
    }

    @Override // a.a.a.a.v.g.d
    public void a(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str2, obj);
            } catch (JSONException unused) {
            }
            a(str, jSONObject);
        }
    }

    @Override // a.a.a.a.v.g.d
    public void a(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) {
            a(str, new JSONObject(map));
        }
    }

    public void a(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) {
            C0005e c0005e = new C0005e(str, jSONObject);
            a.a.a.a.v.b.e();
            synchronized (this.f1417d) {
                this.f1417d.add(c0005e);
            }
            NetworkInfo networkInfo = a.a.a.a.v.f.f1401b;
            boolean z = false;
            if (!(networkInfo != null && networkInfo.isConnected()) || this.f1416c.hasMessages(1)) {
                return;
            }
            Handler handler = this.f1416c;
            long j = a.a.a.a.v.b.f1396b.getLong("key_flt", 0L);
            if (j > 0 && System.currentTimeMillis() - j >= 86400000) {
                z = true;
            }
            handler.sendEmptyMessageDelayed(1, z ? 5000L : 0L);
        }
    }

    public final boolean a(JSONArray jSONArray) {
        InterceptResult invokeL;
        a.a.a.a.t.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            try {
                fVar = new a.a.a.a.t.c(this.f1415b, new a.a.a.a.t.e(jSONArray.toString(), a.a.a.a.t.a.f1376b), true).a();
            } catch (IOException e2) {
                a.a.a.a.v.d.a(e2);
                fVar = null;
            }
            return fVar != null && fVar.f1387a == 200;
        }
        return invokeL.booleanValue;
    }
}
