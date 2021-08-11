package b.a.a.a.x.f;

import a.a.a.a.w.f;
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
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e extends b.a.a.a.x.f.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f1500f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final String f1501b;

    /* renamed from: c  reason: collision with root package name */
    public final Handler f1502c;

    /* renamed from: d  reason: collision with root package name */
    public final LinkedList<d> f1503d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1504e;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f1505a;

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
            this.f1505a = eVar;
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
                        int h2 = b.a.a.a.x.b.h();
                        int a2 = b.a.a.a.x.b.a();
                        int i4 = (i3 - h2) - a2;
                        b.a.a.a.x.d.b("ReportCount: req:%d suc:%d fai:%d mis:%d", Integer.valueOf(i3), Integer.valueOf(h2), Integer.valueOf(a2), Integer.valueOf(i4));
                        if (i4 > 0) {
                            b.a.a.a.x.b.e("key_rpt_mis_c", i4);
                            return;
                        }
                        return;
                    }
                    b.a.a.a.x.d.g("turn on report switch", new Object[0]);
                    this.f1505a.f1504e = true;
                }
                e.d(this.f1505a);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements f.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f1506a;

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
            this.f1506a = eVar;
        }

        @Override // a.a.a.a.w.f.b
        public void a(@Nullable NetworkInfo networkInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, networkInfo) == null) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    this.f1506a.f1502c.removeMessages(1);
                    this.f1506a.f1502c.sendEmptyMessage(1);
                    return;
                }
                this.f1506a.f1502c.removeMessages(1);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final JSONArray f1507b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C0009e c0009e) {
            super(null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0009e};
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
            this.f1507b = new JSONArray();
            a(c0009e);
        }

        @Override // b.a.a.a.x.f.e.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (a()) {
                    return this;
                }
                if (dVar instanceof C0009e) {
                    C0009e c0009e = (C0009e) dVar;
                    this.f1507b.put(c0009e.f1510d);
                    c0009e.f1510d = null;
                    return this;
                } else if (!(dVar instanceof c)) {
                    throw new IllegalArgumentException("Unknown Event type:" + dVar);
                } else {
                    c cVar = (c) dVar;
                    while (!a() && cVar.f1507b.length() > 0) {
                        this.f1507b.put(cVar.f1507b.remove(0));
                    }
                    return this;
                }
            }
            return (d) invokeL.objValue;
        }

        @Override // b.a.a.a.x.f.e.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f1507b.length() >= 10 : invokeV.booleanValue;
        }

        @Override // b.a.a.a.x.f.e.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.a.a.x.d.g("ArrayEvent reported succeed with len:%d", Integer.valueOf(this.f1507b.length()));
                b.a.a.a.x.b.e("key_rpt_suc_c", b.a.a.a.x.b.h() + this.f1507b.length());
            }
        }

        @Override // b.a.a.a.x.f.e.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1507b : (JSONArray) invokeV.objValue;
        }

        @Override // b.a.a.a.x.f.e.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                int i2 = 0;
                while (this.f1507b.length() > 0 && i2 < 1) {
                    this.f1507b.remove(0);
                    i2++;
                }
                b.a.a.a.x.b.e("key_rpt_fai_c", b.a.a.a.x.b.a() + i2);
                b.a.a.a.x.d.g("cut %d datas from ArrayEvent", Integer.valueOf(i2));
            }
        }

        @Override // b.a.a.a.x.f.e.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1507b.length() <= 0 : invokeV.booleanValue;
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

    /* renamed from: b.a.a.a.x.f.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0009e extends f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final String f1508b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f1509c;

        /* renamed from: d  reason: collision with root package name */
        public JSONObject f1510d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0009e(String str, JSONObject jSONObject) {
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
            this.f1508b = str;
            this.f1509c = jSONObject;
            this.f1510d = b.a.a.a.x.f.c.b(str, jSONObject, System.currentTimeMillis());
            if (FunAdSdk.isLogEnabled()) {
                b.a.a.a.x.d.g("report Event:" + this, new Object[0]);
            }
        }

        @Override // b.a.a.a.x.f.e.d
        public d a(d dVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
                if (dVar instanceof C0009e) {
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

        @Override // b.a.a.a.x.f.e.d
        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // b.a.a.a.x.f.e.d
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b.a.a.a.x.d.g("JSONEvent reported succeed", new Object[0]);
                if (this.f1510d != null) {
                    b.a.a.a.x.b.e("key_rpt_suc_c", b.a.a.a.x.b.h() + 1);
                }
            }
        }

        @Override // b.a.a.a.x.f.e.d
        public JSONArray d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.f1510d == null) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(this.f1510d);
                return jSONArray;
            }
            return (JSONArray) invokeV.objValue;
        }

        @Override // b.a.a.a.x.f.e.f
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                b.a.a.a.x.d.g("give up report JSONEvent", new Object[0]);
                this.f1510d = null;
                b.a.a.a.x.b.e("key_rpt_fai_c", b.a.a.a.x.b.a() + 1);
            }
        }

        @Override // b.a.a.a.x.f.e.d
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f1510d == null : invokeV.booleanValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return "{key='" + this.f1508b + ExtendedMessageFormat.QUOTE + ", content=" + this.f1509c + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f1511a;

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

        @Override // b.a.a.a.x.f.e.d
        public long c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                b.a.a.a.x.d.g("RetryEvent reported failed with retryCount:%d", Integer.valueOf(this.f1511a));
                int i2 = this.f1511a;
                int i3 = i2 + 1;
                this.f1511a = i3;
                if (i2 >= 2) {
                    e();
                    this.f1511a = 0;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-655656039, "Lb/a/a/a/x/f/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-655656039, "Lb/a/a/a/x/f/e;");
                return;
            }
        }
        f1500f = !e.class.desiredAssertionStatus();
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
        this.f1503d = new LinkedList<>();
        this.f1504e = true;
        this.f1501b = str;
        HandlerThread handlerThread = new HandlerThread("reporter2");
        handlerThread.start();
        this.f1502c = new a(this, handlerThread.getLooper());
        this.f1502c.obtainMessage(3, b.a.a.a.x.b.g(), 0).sendToTarget();
        a.a.a.a.w.f.a(new b(this));
    }

    public static void d(e eVar) {
        d pollFirst;
        JSONArray jSONArray;
        d peekFirst;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, eVar) == null) {
            while (eVar.f1504e) {
                synchronized (eVar.f1503d) {
                    pollFirst = eVar.f1503d.pollFirst();
                    if (pollFirst == null) {
                        return;
                    }
                    while (!pollFirst.a() && !eVar.f1503d.isEmpty() && (peekFirst = eVar.f1503d.peekFirst()) != null) {
                        pollFirst = pollFirst.a(peekFirst);
                        if (peekFirst.isEmpty()) {
                            eVar.f1503d.removeFirst();
                        } else if (!f1500f && !pollFirst.a()) {
                            throw new AssertionError();
                        }
                    }
                }
                if (eVar.g(pollFirst.d())) {
                    pollFirst.b();
                    int a2 = b.a.a.a.x.b.a();
                    int f2 = b.a.a.a.x.b.f();
                    if (a2 > 0 || f2 > 0) {
                        int h2 = b.a.a.a.x.b.h();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("fai", a2);
                            jSONObject.put("suc", h2);
                            jSONObject.put("mis", f2);
                        } catch (JSONException unused) {
                        }
                        C0009e c0009e = new C0009e("k_rpt", jSONObject);
                        if (c0009e.f1510d == null) {
                            jSONArray = null;
                        } else {
                            jSONArray = new JSONArray();
                            jSONArray.put(c0009e.f1510d);
                        }
                        if (eVar.g(jSONArray)) {
                            b.a.a.a.x.b.c(a2, h2, f2);
                        }
                    }
                } else {
                    long c2 = pollFirst.c();
                    if (!pollFirst.isEmpty()) {
                        synchronized (eVar.f1503d) {
                            eVar.f1503d.addFirst(pollFirst);
                        }
                    }
                    if (c2 > 0) {
                        b.a.a.a.x.d.g("turn off report switch, reScheduleReport delay:%dms", Long.valueOf(c2));
                        eVar.f1504e = false;
                        if (!eVar.f1502c.hasMessages(2)) {
                            eVar.f1502c.sendEmptyMessageDelayed(2, c2);
                        }
                    }
                }
            }
        }
    }

    @Override // b.a.a.a.x.f.d
    public void b(String str, String str2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, str, str2, obj) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(str2, obj);
            } catch (JSONException unused) {
            }
            e(str, jSONObject);
        }
    }

    @Override // b.a.a.a.x.f.d
    public void c(String str, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, map) == null) {
            e(str, new JSONObject(map));
        }
    }

    public void e(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, jSONObject) == null) {
            C0009e c0009e = new C0009e(str, jSONObject);
            b.a.a.a.x.b.i();
            synchronized (this.f1503d) {
                this.f1503d.add(c0009e);
            }
            NetworkInfo networkInfo = a.a.a.a.w.f.f1023b;
            boolean z = false;
            if (!(networkInfo != null && networkInfo.isConnected()) || this.f1502c.hasMessages(1)) {
                return;
            }
            Handler handler = this.f1502c;
            long j2 = b.a.a.a.x.b.f1484b.getLong("key_flt", 0L);
            if (j2 > 0 && System.currentTimeMillis() - j2 >= 86400000) {
                z = true;
            }
            handler.sendEmptyMessageDelayed(1, z ? 5000L : 0L);
        }
    }

    public final boolean g(JSONArray jSONArray) {
        InterceptResult invokeL;
        b.a.a.a.v.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jSONArray)) == null) {
            try {
                fVar = new b.a.a.a.v.c(this.f1501b, new b.a.a.a.v.e(jSONArray.toString(), b.a.a.a.v.a.f1464b), true).a();
            } catch (IOException e2) {
                b.a.a.a.x.d.c(e2);
                fVar = null;
            }
            return fVar != null && fVar.f1475a == 200;
        }
        return invokeL.booleanValue;
    }
}
