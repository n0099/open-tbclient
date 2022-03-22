package c.a.p.j.f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.p.h.d.a;
import c.a.p.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.core.InfoCode;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends c.a.p.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0891a f11823d;

    /* renamed from: e  reason: collision with root package name */
    public g f11824e;

    /* renamed from: f  reason: collision with root package name */
    public f f11825f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.c<String>> f11826g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11827h;
    public boolean i;

    /* renamed from: c.a.p.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0895a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f11828b;

        /* renamed from: c.a.p.j.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0896a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ HandlerC0895a a;

            public RunnableC0896a(HandlerC0895a handlerC0895a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC0895a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = handlerC0895a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.f11843c.get()) {
                    return;
                }
                this.a.f11828b.f11824e.d(64L, 124L);
                this.a.f11828b.f11824e.p();
                this.a.f11828b.k();
                this.a.a.f11843c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0895a(a aVar, Looper looper, f fVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper, fVar};
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
            this.f11828b = aVar;
            this.a = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f11828b.f11799b.f11803d.submit(new RunnableC0896a(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Handler a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f11829b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f11830c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f11831d;

        /* renamed from: c.a.p.j.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0897a extends h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f11832b;

            public C0897a(b bVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11832b = bVar;
                this.a = j;
            }

            @Override // c.a.p.j.f.a.h
            public void a(IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, idSupplier) == null) {
                    if (idSupplier.isSupported()) {
                        this.f11832b.f11831d.i = true;
                    } else if (this.f11832b.f11831d.i) {
                        return;
                    }
                    String oaid = idSupplier.getOAID();
                    this.f11832b.a.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f11832b;
                    bVar.f11831d.n(bVar.f11830c, oaid, elapsedRealtime - this.a);
                }
            }
        }

        /* renamed from: c.a.p.j.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0898b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Throwable a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f11833b;

            public RunnableC0898b(b bVar, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11833b = bVar;
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f11833b.a.removeMessages(0);
                    this.f11833b.f11831d.f11824e.k(Log.getStackTraceString(this.a));
                    this.f11833b.f11831d.f11824e.p();
                    if (this.f11833b.f11830c.f11843c.get()) {
                        return;
                    }
                    this.f11833b.f11830c.f11843c.set(true);
                    this.f11833b.f11831d.k();
                }
            }
        }

        public b(a aVar, Handler handler, Context context, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, handler, context, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11831d = aVar;
            this.a = handler;
            this.f11829b = context;
            this.f11830c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.sendEmptyMessageDelayed(0, 50000L);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    if (!this.f11831d.f11827h) {
                        this.f11831d.f11827h = MdidSdkHelper.InitCert(this.f11829b, this.f11831d.i(this.f11829b, "msa/msa.pem"));
                    }
                    this.f11831d.m(this.f11830c, this.a, this.f11831d.f11827h ? MdidSdkHelper.InitSdk(this.f11829b, false, new C0897a(this, elapsedRealtime)) : InfoCode.INIT_ERROR_CERT_ERROR, 0);
                } catch (Throwable th) {
                    this.f11831d.f11799b.f11803d.submit(new RunnableC0898b(this, th));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f11834b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f11835c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a f11836d;

        public c(a aVar, long j, String str, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j), str, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11836d = aVar;
            this.a = j;
            this.f11834b = str;
            this.f11835c = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11836d.f11824e.g(this.a);
                this.f11836d.f11824e.d(16L, 124L);
                this.f11836d.f11824e.o(this.f11834b);
                if (!TextUtils.isEmpty(this.f11834b) && !TextUtils.equals(this.f11834b, "00000000-0000-0000-0000-000000000000")) {
                    try {
                        String b2 = c.a.p.j.a.b("A10", new c.a.p.h.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f11834b.getBytes("UTF-8")));
                        this.f11836d.f11824e.h(b2);
                        this.f11836d.f11824e.e(b2);
                        this.f11836d.f11824e.d(32L, 124L);
                    } catch (Exception unused) {
                    }
                }
                this.f11836d.f11824e.p();
                if (this.f11835c.f11843c.get()) {
                    return;
                }
                this.f11836d.k();
                this.f11835c.f11843c.set(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f11837b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Handler f11838c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f11839d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f11840e;

        public d(a aVar, int i, f fVar, Handler handler, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i), fVar, handler, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11840e = aVar;
            this.a = i;
            this.f11837b = fVar;
            this.f11838c = handler;
            this.f11839d = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i == 1008612 || i == 1008616 || i == 1008611 || i == 1008615) {
                    if (!this.f11837b.f11843c.get()) {
                        this.f11837b.f11843c.set(true);
                        this.f11840e.k();
                    }
                    this.f11838c.removeMessages(this.f11839d);
                }
                this.f11840e.f11824e.c(this.a);
                this.f11840e.f11824e.d(8L, 124L);
                this.f11840e.f11824e.p();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a.c a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f11841b;

        public e(a aVar, a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11841b = aVar;
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11841b.f11825f.f11843c.get()) {
                    this.f11841b.l(this.a);
                } else {
                    this.f11841b.f11826g.add(this.a);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Future<?> a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f11842b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f11843c;

        public f(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11843c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes2.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11844b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.p.h.c.a.e f11845c;

        /* renamed from: d  reason: collision with root package name */
        public String f11846d;

        /* renamed from: e  reason: collision with root package name */
        public int f11847e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f11848f;

        /* renamed from: g  reason: collision with root package name */
        public long f11849g;

        /* renamed from: h  reason: collision with root package name */
        public String f11850h;
        public String i;
        public String j;
        public final /* synthetic */ a k;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = aVar;
            this.f11844b = true;
            this.f11845c = new c.a.p.h.c.a.e();
            this.f11848f = new ArrayList<>();
        }

        public final JSONObject b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("form_id", this.f11846d);
                    jSONObject.put("lst_fe_ts", this.a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f11845c.d());
                    jSONObject.put("init_res", this.f11847e);
                    jSONObject.put("acquire_ts_cost", this.f11849g);
                    jSONObject.put("oid", this.f11850h);
                    jSONObject.put("sdk_version", this.i);
                    int size = this.f11848f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i = 0; i < min; i++) {
                            jSONObject2.put("id_" + i, this.f11848f.get((size - min) + i));
                        }
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.f11847e == i) {
                return;
            }
            this.f11847e = i;
            this.f11844b = true;
        }

        public void d(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f11845c.c(j, j2)) {
                this.f11844b = true;
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f11848f.contains(str)) {
                return;
            }
            this.f11848f.add(str);
            this.f11844b = true;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11846d : (String) invokeV.objValue;
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || this.f11849g == j) {
                return;
            }
            this.f11849g = j;
            this.f11844b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f11846d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f11846d = str;
                this.f11844b = true;
            }
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.longValue;
        }

        public void j(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) || this.a == j) {
                return;
            }
            this.a = j;
            this.f11844b = true;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.j == str) {
                return;
            }
            if (str == null || !str.equals(this.f11850h)) {
                this.j = str;
                this.f11844b = true;
            }
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.i : (String) invokeV.objValue;
        }

        public void m(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.equals(this.i, str)) {
                return;
            }
            this.i = str;
            this.f11844b = true;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f11850h : (String) invokeV.objValue;
        }

        public void o(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (str2 = this.f11850h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f11850h = str;
                this.f11844b = true;
            }
        }

        public boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (this.f11844b) {
                    try {
                        this.k.f11823d.i("cache.dat", b().toString(), true);
                        this.f11844b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean q() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                String g2 = this.k.f11823d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f11846d = jSONObject.optString("form_id");
                        this.a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f11845c.b(jSONObject.getLong("flags"));
                        this.f11847e = jSONObject.optInt("init_res");
                        this.f11849g = jSONObject.optLong("acquire_ts_cost");
                        this.f11850h = jSONObject.optString("oid");
                        this.i = jSONObject.optString("sdk_version");
                        this.f11848f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i = optJSONObject.getInt("count");
                            for (int i2 = 0; i2 < i; i2++) {
                                String string = optJSONObject.getString("id_" + i2);
                                if (TextUtils.isEmpty(string)) {
                                    this.f11848f.clear();
                                    return false;
                                }
                                this.f11848f.add(string);
                            }
                        }
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class h implements IIdentifierListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public h() {
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

        public abstract void a(IdSupplier idSupplier);

        @Override // com.bun.miitmdid.interfaces.IIdentifierListener
        public void onSupport(IdSupplier idSupplier) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, idSupplier) == null) {
                a(idSupplier);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("oid");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11824e = new g(this);
        this.f11826g = new ArrayList();
        this.f11827h = false;
        this.i = false;
    }

    @Override // c.a.p.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11824e.f() : (String) invokeV.objValue;
    }

    @Override // c.a.p.j.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f11823d = this.a.f(e());
            Context context = this.f11799b.a;
            f fVar = new f(this);
            this.f11825f = fVar;
            this.f11824e.q();
            long currentTimeMillis = System.currentTimeMillis();
            if (!bVar.a && !r(currentTimeMillis)) {
                fVar.f11843c.set(true);
                return;
            }
            this.f11824e.j(currentTimeMillis);
            this.f11824e.d(4L, 124L);
            this.f11824e.g(0L);
            this.f11824e.m("1.0.26");
            this.f11824e.p();
            this.f11799b.f11804e.submit(new b(this, new HandlerC0895a(this, Looper.getMainLooper(), fVar), context, fVar));
        }
    }

    @Override // c.a.p.j.a
    public void g(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f11799b.f11803d.submit(new e(this, cVar));
        }
    }

    public final String i(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeLL = interceptable.invokeLL(1048579, this, context, str)) != null) {
            return (String) invokeLL.objValue;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return sb.toString();
                }
                sb.append(readLine);
                sb.append('\n');
            }
        } catch (IOException unused) {
            return "";
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            for (a.c<String> cVar : this.f11826g) {
                l(cVar);
            }
            this.f11826g.clear();
        }
    }

    public final void l(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f11824e.f())) {
                cVar.a(this.f11824e.f11847e, null, bundle);
            } else {
                cVar.onResult(this.f11824e.f(), bundle);
            }
        }
    }

    public final void m(f fVar, Handler handler, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048582, this, fVar, handler, i, i2) == null) {
            fVar.a = this.f11799b.f11803d.submit(new d(this, i, fVar, handler, i2));
        }
    }

    public final void n(f fVar, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{fVar, str, Long.valueOf(j)}) == null) {
            fVar.f11842b = this.f11799b.f11803d.submit(new c(this, j, str, fVar));
        }
    }

    public final boolean r(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) ? Math.abs(j - this.f11824e.i()) > 604800000 || (!TextUtils.equals(this.f11824e.l(), "1.0.26") && TextUtils.isEmpty(this.f11824e.n())) : invokeJ.booleanValue;
    }
}
