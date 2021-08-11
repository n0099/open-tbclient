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
    public a.C1372a f29366d;

    /* renamed from: e  reason: collision with root package name */
    public e f29367e;

    /* renamed from: f  reason: collision with root package name */
    public d f29368f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f29369g;

    /* renamed from: c.a.r.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC1376a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f29370a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f29371b;

        /* renamed from: c.a.r.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1377a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC1376a f29372e;

            public RunnableC1377a(HandlerC1376a handlerC1376a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC1376a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f29372e = handlerC1376a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f29372e.f29370a.f29391c.get()) {
                    return;
                }
                this.f29372e.f29371b.f29367e.d(64L, 124L);
                this.f29372e.f29371b.f29367e.m();
                this.f29372e.f29371b.i();
                this.f29372e.f29370a.f29391c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC1376a(a aVar, Looper looper, d dVar) {
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
            this.f29371b = aVar;
            this.f29370a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f29371b.f29334b.f29341d.submit(new RunnableC1377a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f29373e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f29374f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f29375g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f29376h;

        /* renamed from: c.a.r.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1378a extends f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f29377a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f29378b;

            /* renamed from: c.a.r.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public class RunnableC1379a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f29379e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f29380f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f29381g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ C1378a f29382h;

                public RunnableC1379a(C1378a c1378a, long j2, boolean z, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1378a, Long.valueOf(j2), Boolean.valueOf(z), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f29382h = c1378a;
                    this.f29379e = j2;
                    this.f29380f = z;
                    this.f29381g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f29382h.f29378b.f29376h.f29367e.i(this.f29379e - this.f29382h.f29377a);
                        this.f29382h.f29378b.f29376h.f29367e.d(this.f29380f ? 1L : 2L, 3L);
                        this.f29382h.f29378b.f29376h.f29367e.d(16L, 124L);
                        this.f29382h.f29378b.f29376h.f29367e.h(this.f29381g);
                        if (!TextUtils.isEmpty(this.f29381g)) {
                            try {
                                String b2 = c.a.r.h.a.b("A10", new c.a.r.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f29381g.getBytes("UTF-8")));
                                this.f29382h.f29378b.f29376h.f29367e.e(b2);
                                this.f29382h.f29378b.f29376h.f29367e.l(b2);
                                this.f29382h.f29378b.f29376h.f29367e.d(32L, 124L);
                            } catch (Exception unused) {
                            }
                        }
                        this.f29382h.f29378b.f29376h.f29367e.m();
                        if (this.f29382h.f29378b.f29375g.f29391c.get()) {
                            return;
                        }
                        this.f29382h.f29378b.f29376h.i();
                        this.f29382h.f29378b.f29375g.f29391c.set(true);
                    }
                }
            }

            public C1378a(b bVar, long j2) {
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
                this.f29378b = bVar;
                this.f29377a = j2;
            }

            @Override // c.a.r.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, idSupplier) == null) {
                    String oaid = idSupplier.getOAID();
                    this.f29378b.f29373e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f29378b;
                    bVar.f29375g.f29390b = bVar.f29376h.f29334b.f29341d.submit(new RunnableC1379a(this, elapsedRealtime, z, oaid));
                }
            }
        }

        /* renamed from: c.a.r.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1380b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f29383e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f29384f;

            public RunnableC1380b(b bVar, int i2) {
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
                this.f29384f = bVar;
                this.f29383e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = this.f29383e;
                    if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                        if (!this.f29384f.f29375g.f29391c.get()) {
                            this.f29384f.f29375g.f29391c.set(true);
                            this.f29384f.f29376h.i();
                        }
                        this.f29384f.f29373e.removeMessages(0);
                    }
                    this.f29384f.f29376h.f29367e.c(this.f29383e);
                    this.f29384f.f29376h.f29367e.d(8L, 124L);
                    this.f29384f.f29376h.f29367e.m();
                }
            }
        }

        /* loaded from: classes4.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f29385e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f29386f;

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
                this.f29386f = bVar;
                this.f29385e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f29386f.f29373e.removeMessages(0);
                    this.f29386f.f29376h.f29367e.j(Log.getStackTraceString(this.f29385e));
                    this.f29386f.f29376h.f29367e.m();
                    if (this.f29386f.f29375g.f29391c.get()) {
                        return;
                    }
                    this.f29386f.f29375g.f29391c.set(true);
                    this.f29386f.f29376h.i();
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
            this.f29376h = aVar;
            this.f29373e = handler;
            this.f29374f = context;
            this.f29375g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29373e.sendEmptyMessageDelayed(0, 50000L);
                try {
                    int InitSdk = new MdidSdk().InitSdk(this.f29374f, new C1378a(this, SystemClock.elapsedRealtime()));
                    this.f29375g.f29389a = this.f29376h.f29334b.f29341d.submit(new RunnableC1380b(this, InitSdk));
                } catch (Throwable th) {
                    this.f29376h.f29334b.f29341d.submit(new c(this, th));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f29387e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f29388f;

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
            this.f29388f = aVar;
            this.f29387e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f29388f.f29368f.f29391c.get()) {
                    this.f29388f.j(this.f29387e);
                } else {
                    this.f29388f.f29369g.add(this.f29387e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f29389a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f29390b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f29391c;

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
            this.f29391c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes4.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f29392a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f29393b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.r.g.c.a.e f29394c;

        /* renamed from: d  reason: collision with root package name */
        public String f29395d;

        /* renamed from: e  reason: collision with root package name */
        public int f29396e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f29397f;

        /* renamed from: g  reason: collision with root package name */
        public long f29398g;

        /* renamed from: h  reason: collision with root package name */
        public String f29399h;

        /* renamed from: i  reason: collision with root package name */
        public String f29400i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f29401j;

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
            this.f29401j = aVar;
            this.f29393b = true;
            this.f29394c = new c.a.r.g.c.a.e();
            this.f29397f = new ArrayList<>();
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29395d : (String) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f29396e == i2) {
                return;
            }
            this.f29396e = i2;
            this.f29393b = true;
        }

        public void d(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f29394c.c(j2, j3)) {
                this.f29393b = true;
            }
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f29395d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f29395d = str;
                this.f29393b = true;
            }
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29392a : invokeV.longValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.f29392a == j2) {
                return;
            }
            this.f29392a = j2;
            this.f29393b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f29399h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f29399h = str;
                this.f29393b = true;
            }
        }

        public void i(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) || this.f29398g == j2) {
                return;
            }
            this.f29398g = j2;
            this.f29393b = true;
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || this.f29400i == str) {
                return;
            }
            if (str == null || !str.equals(this.f29399h)) {
                this.f29400i = str;
                this.f29393b = true;
            }
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String g2 = this.f29401j.f29366d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f29395d = jSONObject.optString("form_id");
                        this.f29392a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f29394c.b(jSONObject.getLong("flags"));
                        this.f29396e = jSONObject.optInt("init_res");
                        this.f29398g = jSONObject.optLong("acquire_ts_cost");
                        this.f29399h = jSONObject.optString("oid");
                        this.f29397f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f29397f.clear();
                                    return false;
                                }
                                this.f29397f.add(string);
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
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f29397f.contains(str)) {
                return;
            }
            this.f29397f.add(str);
            this.f29393b = true;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f29393b) {
                    try {
                        this.f29401j.f29366d.i("cache.dat", n().toString(), true);
                        this.f29393b = false;
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
                    jSONObject.put("form_id", this.f29395d);
                    jSONObject.put("lst_fe_ts", this.f29392a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f29394c.d());
                    jSONObject.put("init_res", this.f29396e);
                    jSONObject.put("acquire_ts_cost", this.f29398g);
                    jSONObject.put("oid", this.f29399h);
                    int size = this.f29397f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f29397f.get((size - min) + i2));
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
        this.f29367e = new e(this);
        this.f29369g = new ArrayList();
    }

    @Override // c.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29367e.b() : (String) invokeV.objValue;
    }

    @Override // c.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f29366d = this.f29333a.f(e());
            Context context = this.f29334b.f29338a;
            d dVar = new d(this);
            this.f29368f = dVar;
            this.f29367e.k();
            long currentTimeMillis = System.currentTimeMillis();
            if (!cVar.f29343a && Math.abs(currentTimeMillis - this.f29367e.f()) <= 604800000) {
                dVar.f29391c.set(true);
                return;
            }
            this.f29367e.g(currentTimeMillis);
            this.f29367e.d(4L, 124L);
            this.f29367e.i(0L);
            this.f29367e.m();
            this.f29334b.f29342e.submit(new b(this, new HandlerC1376a(this, Looper.getMainLooper(), dVar), context, dVar));
        }
    }

    @Override // c.a.r.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f29334b.f29341d.submit(new c(this, dVar));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f29369g) {
                j(dVar);
            }
            this.f29369g.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f29367e.b())) {
                dVar.a(this.f29367e.f29396e, null, bundle);
            } else {
                dVar.onResult(this.f29367e.b(), bundle);
            }
        }
    }
}
