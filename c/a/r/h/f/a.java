package c.a.r.h.f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.r.g.d.a;
import c.a.r.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.core.IIdentifierListener;
import com.bun.miitmdid.core.MdidSdk;
import com.bun.miitmdid.supplier.IdSupplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends c.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1379a f29648d;

    /* renamed from: e  reason: collision with root package name */
    public e f29649e;

    /* renamed from: f  reason: collision with root package name */
    public d f29650f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f29651g;

    /* renamed from: c.a.r.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1383a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f29652a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f29653b;

        /* renamed from: c.a.r.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1384a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC1383a f29654e;

            public RunnableC1384a(HandlerC1383a handlerC1383a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC1383a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29654e = handlerC1383a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29654e.f29652a.f29673c.get()) {
                    return;
                }
                this.f29654e.f29653b.f29649e.d(64L, 124L);
                this.f29654e.f29653b.f29649e.m();
                this.f29654e.f29653b.i();
                this.f29654e.f29652a.f29673c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1383a(a aVar, Looper looper, d dVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper, dVar};
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
            this.f29653b = aVar;
            this.f29652a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f29653b.f29616b.f29623d.submit(new RunnableC1384a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f29655e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f29656f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29657g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f29658h;

        /* renamed from: c.a.r.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1385a extends f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f29659a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f29660b;

            /* renamed from: c.a.r.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC1386a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f29661e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f29662f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f29663g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ C1385a f29664h;

                public RunnableC1386a(C1385a c1385a, long j2, boolean z, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1385a, Long.valueOf(j2), Boolean.valueOf(z), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29664h = c1385a;
                    this.f29661e = j2;
                    this.f29662f = z;
                    this.f29663g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f29664h.f29660b.f29658h.f29649e.i(this.f29661e - this.f29664h.f29659a);
                        this.f29664h.f29660b.f29658h.f29649e.d(this.f29662f ? 1L : 2L, 3L);
                        this.f29664h.f29660b.f29658h.f29649e.d(16L, 124L);
                        this.f29664h.f29660b.f29658h.f29649e.h(this.f29663g);
                        if (!TextUtils.isEmpty(this.f29663g)) {
                            try {
                                String b2 = c.a.r.h.a.b("A10", new c.a.r.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f29663g.getBytes("UTF-8")));
                                this.f29664h.f29660b.f29658h.f29649e.e(b2);
                                this.f29664h.f29660b.f29658h.f29649e.l(b2);
                                this.f29664h.f29660b.f29658h.f29649e.d(32L, 124L);
                            } catch (Exception unused) {
                            }
                        }
                        this.f29664h.f29660b.f29658h.f29649e.m();
                        if (this.f29664h.f29660b.f29657g.f29673c.get()) {
                            return;
                        }
                        this.f29664h.f29660b.f29658h.i();
                        this.f29664h.f29660b.f29657g.f29673c.set(true);
                    }
                }
            }

            public C1385a(b bVar, long j2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Long.valueOf(j2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29660b = bVar;
                this.f29659a = j2;
            }

            @Override // c.a.r.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, idSupplier) == null) {
                    String oaid = idSupplier.getOAID();
                    this.f29660b.f29655e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f29660b;
                    bVar.f29657g.f29672b = bVar.f29658h.f29616b.f29623d.submit(new RunnableC1386a(this, elapsedRealtime, z, oaid));
                }
            }
        }

        /* renamed from: c.a.r.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1387b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f29665e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f29666f;

            public RunnableC1387b(b bVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29666f = bVar;
                this.f29665e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = this.f29665e;
                    if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                        if (!this.f29666f.f29657g.f29673c.get()) {
                            this.f29666f.f29657g.f29673c.set(true);
                            this.f29666f.f29658h.i();
                        }
                        this.f29666f.f29655e.removeMessages(0);
                    }
                    this.f29666f.f29658h.f29649e.c(this.f29665e);
                    this.f29666f.f29658h.f29649e.d(8L, 124L);
                    this.f29666f.f29658h.f29649e.m();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f29667e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f29668f;

            public c(b bVar, Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, th};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29668f = bVar;
                this.f29667e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f29668f.f29655e.removeMessages(0);
                    this.f29668f.f29658h.f29649e.j(Log.getStackTraceString(this.f29667e));
                    this.f29668f.f29658h.f29649e.m();
                    if (this.f29668f.f29657g.f29673c.get()) {
                        return;
                    }
                    this.f29668f.f29657g.f29673c.set(true);
                    this.f29668f.f29658h.i();
                }
            }
        }

        public b(a aVar, Handler handler, Context context, d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, handler, context, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29658h = aVar;
            this.f29655e = handler;
            this.f29656f = context;
            this.f29657g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29655e.sendEmptyMessageDelayed(0, 50000L);
                try {
                    int InitSdk = new MdidSdk().InitSdk(this.f29656f, new C1385a(this, SystemClock.elapsedRealtime()));
                    this.f29657g.f29671a = this.f29658h.f29616b.f29623d.submit(new RunnableC1387b(this, InitSdk));
                } catch (Throwable th) {
                    this.f29658h.f29616b.f29623d.submit(new c(this, th));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f29669e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f29670f;

        public c(a aVar, a.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29670f = aVar;
            this.f29669e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29670f.f29650f.f29673c.get()) {
                    this.f29670f.j(this.f29669e);
                } else {
                    this.f29670f.f29651g.add(this.f29669e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f29671a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f29672b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f29673c;

        public d(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29673c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f29674a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f29675b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.r.g.c.a.e f29676c;

        /* renamed from: d  reason: collision with root package name */
        public String f29677d;

        /* renamed from: e  reason: collision with root package name */
        public int f29678e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f29679f;

        /* renamed from: g  reason: collision with root package name */
        public long f29680g;

        /* renamed from: h  reason: collision with root package name */
        public String f29681h;

        /* renamed from: i  reason: collision with root package name */
        public String f29682i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f29683j;

        public e(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29683j = aVar;
            this.f29675b = true;
            this.f29676c = new c.a.r.g.c.a.e();
            this.f29679f = new ArrayList<>();
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29677d : (String) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f29678e == i2) {
                return;
            }
            this.f29678e = i2;
            this.f29675b = true;
        }

        public void d(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f29676c.c(j2, j3)) {
                this.f29675b = true;
            }
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f29677d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f29677d = str;
                this.f29675b = true;
            }
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29674a : invokeV.longValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.f29674a == j2) {
                return;
            }
            this.f29674a = j2;
            this.f29675b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f29681h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f29681h = str;
                this.f29675b = true;
            }
        }

        public void i(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) || this.f29680g == j2) {
                return;
            }
            this.f29680g = j2;
            this.f29675b = true;
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || this.f29682i == str) {
                return;
            }
            if (str == null || !str.equals(this.f29681h)) {
                this.f29682i = str;
                this.f29675b = true;
            }
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String g2 = this.f29683j.f29648d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f29677d = jSONObject.optString("form_id");
                        this.f29674a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f29676c.b(jSONObject.getLong("flags"));
                        this.f29678e = jSONObject.optInt("init_res");
                        this.f29680g = jSONObject.optLong("acquire_ts_cost");
                        this.f29681h = jSONObject.optString("oid");
                        this.f29679f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f29679f.clear();
                                    return false;
                                }
                                this.f29679f.add(string);
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

        public void l(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f29679f.contains(str)) {
                return;
            }
            this.f29679f.add(str);
            this.f29675b = true;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f29675b) {
                    try {
                        this.f29683j.f29648d.i("cache.dat", n().toString(), true);
                        this.f29675b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final JSONObject n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("form_id", this.f29677d);
                    jSONObject.put("lst_fe_ts", this.f29674a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f29676c.d());
                    jSONObject.put("init_res", this.f29678e);
                    jSONObject.put("acquire_ts_cost", this.f29680g);
                    jSONObject.put("oid", this.f29681h);
                    int size = this.f29679f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f29679f.get((size - min) + i2));
                        }
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class f implements IIdentifierListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.bun.miitmdid.core.IIdentifierListener
        public void OnSupport(boolean z, IdSupplier idSupplier) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, idSupplier) == null) {
                a(z, idSupplier);
            }
        }

        public abstract void a(boolean z, IdSupplier idSupplier);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("oid");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29649e = new e(this);
        this.f29651g = new ArrayList();
    }

    @Override // c.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29649e.b() : (String) invokeV.objValue;
    }

    @Override // c.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f29648d = this.f29615a.f(e());
            Context context = this.f29616b.f29620a;
            d dVar = new d(this);
            this.f29650f = dVar;
            this.f29649e.k();
            long currentTimeMillis = System.currentTimeMillis();
            if (!cVar.f29625a && Math.abs(currentTimeMillis - this.f29649e.f()) <= 604800000) {
                dVar.f29673c.set(true);
                return;
            }
            this.f29649e.g(currentTimeMillis);
            this.f29649e.d(4L, 124L);
            this.f29649e.i(0L);
            this.f29649e.m();
            this.f29616b.f29624e.submit(new b(this, new HandlerC1383a(this, Looper.getMainLooper(), dVar), context, dVar));
        }
    }

    @Override // c.a.r.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f29616b.f29623d.submit(new c(this, dVar));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f29651g) {
                j(dVar);
            }
            this.f29651g.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f29649e.b())) {
                dVar.a(this.f29649e.f29678e, null, bundle);
            } else {
                dVar.onResult(this.f29649e.b(), bundle);
            }
        }
    }
}
