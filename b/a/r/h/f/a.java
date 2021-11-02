package b.a.r.h.f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import b.a.r.g.d.a;
import b.a.r.h.a;
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
public class a extends b.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0733a f14588d;

    /* renamed from: e  reason: collision with root package name */
    public e f14589e;

    /* renamed from: f  reason: collision with root package name */
    public d f14590f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f14591g;

    /* renamed from: b.a.r.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC0737a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f14592a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f14593b;

        /* renamed from: b.a.r.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0738a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC0737a f14594e;

            public RunnableC0738a(HandlerC0737a handlerC0737a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC0737a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14594e = handlerC0737a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f14594e.f14592a.f14613c.get()) {
                    return;
                }
                this.f14594e.f14593b.f14589e.d(64L, 124L);
                this.f14594e.f14593b.f14589e.m();
                this.f14594e.f14593b.i();
                this.f14594e.f14592a.f14613c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0737a(a aVar, Looper looper, d dVar) {
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
            this.f14593b = aVar;
            this.f14592a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f14593b.f14556b.f14563d.submit(new RunnableC0738a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f14595e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f14596f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f14597g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f14598h;

        /* renamed from: b.a.r.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0739a extends f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14599a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f14600b;

            /* renamed from: b.a.r.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC0740a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f14601e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f14602f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f14603g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ C0739a f14604h;

                public RunnableC0740a(C0739a c0739a, long j, boolean z, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0739a, Long.valueOf(j), Boolean.valueOf(z), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f14604h = c0739a;
                    this.f14601e = j;
                    this.f14602f = z;
                    this.f14603g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f14604h.f14600b.f14598h.f14589e.i(this.f14601e - this.f14604h.f14599a);
                        this.f14604h.f14600b.f14598h.f14589e.d(this.f14602f ? 1L : 2L, 3L);
                        this.f14604h.f14600b.f14598h.f14589e.d(16L, 124L);
                        this.f14604h.f14600b.f14598h.f14589e.h(this.f14603g);
                        if (!TextUtils.isEmpty(this.f14603g)) {
                            try {
                                String b2 = b.a.r.h.a.b("A10", new b.a.r.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f14603g.getBytes("UTF-8")));
                                this.f14604h.f14600b.f14598h.f14589e.e(b2);
                                this.f14604h.f14600b.f14598h.f14589e.l(b2);
                                this.f14604h.f14600b.f14598h.f14589e.d(32L, 124L);
                            } catch (Exception unused) {
                            }
                        }
                        this.f14604h.f14600b.f14598h.f14589e.m();
                        if (this.f14604h.f14600b.f14597g.f14613c.get()) {
                            return;
                        }
                        this.f14604h.f14600b.f14598h.i();
                        this.f14604h.f14600b.f14597g.f14613c.set(true);
                    }
                }
            }

            public C0739a(b bVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f14600b = bVar;
                this.f14599a = j;
            }

            @Override // b.a.r.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, idSupplier) == null) {
                    String oaid = idSupplier.getOAID();
                    this.f14600b.f14595e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f14600b;
                    bVar.f14597g.f14612b = bVar.f14598h.f14556b.f14563d.submit(new RunnableC0740a(this, elapsedRealtime, z, oaid));
                }
            }
        }

        /* renamed from: b.a.r.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0741b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f14605e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f14606f;

            public RunnableC0741b(b bVar, int i2) {
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
                this.f14606f = bVar;
                this.f14605e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = this.f14605e;
                    if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                        if (!this.f14606f.f14597g.f14613c.get()) {
                            this.f14606f.f14597g.f14613c.set(true);
                            this.f14606f.f14598h.i();
                        }
                        this.f14606f.f14595e.removeMessages(0);
                    }
                    this.f14606f.f14598h.f14589e.c(this.f14605e);
                    this.f14606f.f14598h.f14589e.d(8L, 124L);
                    this.f14606f.f14598h.f14589e.m();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f14607e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f14608f;

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
                this.f14608f = bVar;
                this.f14607e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f14608f.f14595e.removeMessages(0);
                    this.f14608f.f14598h.f14589e.j(Log.getStackTraceString(this.f14607e));
                    this.f14608f.f14598h.f14589e.m();
                    if (this.f14608f.f14597g.f14613c.get()) {
                        return;
                    }
                    this.f14608f.f14597g.f14613c.set(true);
                    this.f14608f.f14598h.i();
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
            this.f14598h = aVar;
            this.f14595e = handler;
            this.f14596f = context;
            this.f14597g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f14595e.sendEmptyMessageDelayed(0, 50000L);
                try {
                    int InitSdk = new MdidSdk().InitSdk(this.f14596f, new C0739a(this, SystemClock.elapsedRealtime()));
                    this.f14597g.f14611a = this.f14598h.f14556b.f14563d.submit(new RunnableC0741b(this, InitSdk));
                } catch (Throwable th) {
                    this.f14598h.f14556b.f14563d.submit(new c(this, th));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f14609e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f14610f;

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
            this.f14610f = aVar;
            this.f14609e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f14610f.f14590f.f14613c.get()) {
                    this.f14610f.j(this.f14609e);
                } else {
                    this.f14610f.f14591g.add(this.f14609e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f14611a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f14612b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f14613c;

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
            this.f14613c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f14614a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f14615b;

        /* renamed from: c  reason: collision with root package name */
        public b.a.r.g.c.a.e f14616c;

        /* renamed from: d  reason: collision with root package name */
        public String f14617d;

        /* renamed from: e  reason: collision with root package name */
        public int f14618e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f14619f;

        /* renamed from: g  reason: collision with root package name */
        public long f14620g;

        /* renamed from: h  reason: collision with root package name */
        public String f14621h;

        /* renamed from: i  reason: collision with root package name */
        public String f14622i;
        public final /* synthetic */ a j;

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
            this.j = aVar;
            this.f14615b = true;
            this.f14616c = new b.a.r.g.c.a.e();
            this.f14619f = new ArrayList<>();
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14617d : (String) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f14618e == i2) {
                return;
            }
            this.f14618e = i2;
            this.f14615b = true;
        }

        public void d(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f14616c.c(j, j2)) {
                this.f14615b = true;
            }
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f14617d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f14617d = str;
                this.f14615b = true;
            }
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14614a : invokeV.longValue;
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || this.f14614a == j) {
                return;
            }
            this.f14614a = j;
            this.f14615b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f14621h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f14621h = str;
                this.f14615b = true;
            }
        }

        public void i(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048583, this, j) == null) || this.f14620g == j) {
                return;
            }
            this.f14620g = j;
            this.f14615b = true;
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || this.f14622i == str) {
                return;
            }
            if (str == null || !str.equals(this.f14621h)) {
                this.f14622i = str;
                this.f14615b = true;
            }
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String g2 = this.j.f14588d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f14617d = jSONObject.optString("form_id");
                        this.f14614a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f14616c.b(jSONObject.getLong("flags"));
                        this.f14618e = jSONObject.optInt("init_res");
                        this.f14620g = jSONObject.optLong("acquire_ts_cost");
                        this.f14621h = jSONObject.optString("oid");
                        this.f14619f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f14619f.clear();
                                    return false;
                                }
                                this.f14619f.add(string);
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
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f14619f.contains(str)) {
                return;
            }
            this.f14619f.add(str);
            this.f14615b = true;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f14615b) {
                    try {
                        this.j.f14588d.i("cache.dat", n().toString(), true);
                        this.f14615b = false;
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
                    jSONObject.put("form_id", this.f14617d);
                    jSONObject.put("lst_fe_ts", this.f14614a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f14616c.d());
                    jSONObject.put("init_res", this.f14618e);
                    jSONObject.put("acquire_ts_cost", this.f14620g);
                    jSONObject.put("oid", this.f14621h);
                    int size = this.f14619f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f14619f.get((size - min) + i2));
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
        this.f14589e = new e(this);
        this.f14591g = new ArrayList();
    }

    @Override // b.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14589e.b() : (String) invokeV.objValue;
    }

    @Override // b.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f14588d = this.f14555a.f(e());
            Context context = this.f14556b.f14560a;
            d dVar = new d(this);
            this.f14590f = dVar;
            this.f14589e.k();
            long currentTimeMillis = System.currentTimeMillis();
            if (!cVar.f14565a && Math.abs(currentTimeMillis - this.f14589e.f()) <= 604800000) {
                dVar.f14613c.set(true);
                return;
            }
            this.f14589e.g(currentTimeMillis);
            this.f14589e.d(4L, 124L);
            this.f14589e.i(0L);
            this.f14589e.m();
            this.f14556b.f14564e.submit(new b(this, new HandlerC0737a(this, Looper.getMainLooper(), dVar), context, dVar));
        }
    }

    @Override // b.a.r.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f14556b.f14563d.submit(new c(this, dVar));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f14591g) {
                j(dVar);
            }
            this.f14591g.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f14589e.b())) {
                dVar.a(this.f14589e.f14618e, null, bundle);
            } else {
                dVar.onResult(this.f14589e.b(), bundle);
            }
        }
    }
}
