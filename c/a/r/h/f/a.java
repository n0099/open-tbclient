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
/* loaded from: classes3.dex */
public class a extends c.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0737a f15510d;

    /* renamed from: e  reason: collision with root package name */
    public e f15511e;

    /* renamed from: f  reason: collision with root package name */
    public d f15512f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f15513g;

    /* renamed from: c.a.r.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0741a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15514a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f15515b;

        /* renamed from: c.a.r.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0742a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC0741a f15516e;

            public RunnableC0742a(HandlerC0741a handlerC0741a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC0741a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15516e = handlerC0741a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15516e.f15514a.f15535c.get()) {
                    return;
                }
                this.f15516e.f15515b.f15511e.d(64L, 124L);
                this.f15516e.f15515b.f15511e.m();
                this.f15516e.f15515b.i();
                this.f15516e.f15514a.f15535c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0741a(a aVar, Looper looper, d dVar) {
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
            this.f15515b = aVar;
            this.f15514a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f15515b.f15478b.f15485d.submit(new RunnableC0742a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f15517e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f15518f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f15519g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f15520h;

        /* renamed from: c.a.r.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0743a extends f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f15521a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f15522b;

            /* renamed from: c.a.r.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0744a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f15523e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f15524f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f15525g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ C0743a f15526h;

                public RunnableC0744a(C0743a c0743a, long j2, boolean z, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0743a, Long.valueOf(j2), Boolean.valueOf(z), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f15526h = c0743a;
                    this.f15523e = j2;
                    this.f15524f = z;
                    this.f15525g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f15526h.f15522b.f15520h.f15511e.i(this.f15523e - this.f15526h.f15521a);
                        this.f15526h.f15522b.f15520h.f15511e.d(this.f15524f ? 1L : 2L, 3L);
                        this.f15526h.f15522b.f15520h.f15511e.d(16L, 124L);
                        this.f15526h.f15522b.f15520h.f15511e.h(this.f15525g);
                        if (!TextUtils.isEmpty(this.f15525g)) {
                            try {
                                String b2 = c.a.r.h.a.b("A10", new c.a.r.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f15525g.getBytes("UTF-8")));
                                this.f15526h.f15522b.f15520h.f15511e.e(b2);
                                this.f15526h.f15522b.f15520h.f15511e.l(b2);
                                this.f15526h.f15522b.f15520h.f15511e.d(32L, 124L);
                            } catch (Exception unused) {
                            }
                        }
                        this.f15526h.f15522b.f15520h.f15511e.m();
                        if (this.f15526h.f15522b.f15519g.f15535c.get()) {
                            return;
                        }
                        this.f15526h.f15522b.f15520h.i();
                        this.f15526h.f15522b.f15519g.f15535c.set(true);
                    }
                }
            }

            public C0743a(b bVar, long j2) {
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
                this.f15522b = bVar;
                this.f15521a = j2;
            }

            @Override // c.a.r.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, idSupplier) == null) {
                    String oaid = idSupplier.getOAID();
                    this.f15522b.f15517e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f15522b;
                    bVar.f15519g.f15534b = bVar.f15520h.f15478b.f15485d.submit(new RunnableC0744a(this, elapsedRealtime, z, oaid));
                }
            }
        }

        /* renamed from: c.a.r.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0745b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f15527e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f15528f;

            public RunnableC0745b(b bVar, int i2) {
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
                this.f15528f = bVar;
                this.f15527e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = this.f15527e;
                    if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                        if (!this.f15528f.f15519g.f15535c.get()) {
                            this.f15528f.f15519g.f15535c.set(true);
                            this.f15528f.f15520h.i();
                        }
                        this.f15528f.f15517e.removeMessages(0);
                    }
                    this.f15528f.f15520h.f15511e.c(this.f15527e);
                    this.f15528f.f15520h.f15511e.d(8L, 124L);
                    this.f15528f.f15520h.f15511e.m();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f15529e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f15530f;

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
                this.f15530f = bVar;
                this.f15529e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f15530f.f15517e.removeMessages(0);
                    this.f15530f.f15520h.f15511e.j(Log.getStackTraceString(this.f15529e));
                    this.f15530f.f15520h.f15511e.m();
                    if (this.f15530f.f15519g.f15535c.get()) {
                        return;
                    }
                    this.f15530f.f15519g.f15535c.set(true);
                    this.f15530f.f15520h.i();
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
            this.f15520h = aVar;
            this.f15517e = handler;
            this.f15518f = context;
            this.f15519g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15517e.sendEmptyMessageDelayed(0, 50000L);
                try {
                    int InitSdk = new MdidSdk().InitSdk(this.f15518f, new C0743a(this, SystemClock.elapsedRealtime()));
                    this.f15519g.f15533a = this.f15520h.f15478b.f15485d.submit(new RunnableC0745b(this, InitSdk));
                } catch (Throwable th) {
                    this.f15520h.f15478b.f15485d.submit(new c(this, th));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f15531e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15532f;

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
            this.f15532f = aVar;
            this.f15531e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f15532f.f15512f.f15535c.get()) {
                    this.f15532f.j(this.f15531e);
                } else {
                    this.f15532f.f15513g.add(this.f15531e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f15533a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f15534b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f15535c;

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
            this.f15535c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15536a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15537b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.r.g.c.a.e f15538c;

        /* renamed from: d  reason: collision with root package name */
        public String f15539d;

        /* renamed from: e  reason: collision with root package name */
        public int f15540e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f15541f;

        /* renamed from: g  reason: collision with root package name */
        public long f15542g;

        /* renamed from: h  reason: collision with root package name */
        public String f15543h;

        /* renamed from: i  reason: collision with root package name */
        public String f15544i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f15545j;

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
            this.f15545j = aVar;
            this.f15537b = true;
            this.f15538c = new c.a.r.g.c.a.e();
            this.f15541f = new ArrayList<>();
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15539d : (String) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f15540e == i2) {
                return;
            }
            this.f15540e = i2;
            this.f15537b = true;
        }

        public void d(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f15538c.c(j2, j3)) {
                this.f15537b = true;
            }
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f15539d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15539d = str;
                this.f15537b = true;
            }
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15536a : invokeV.longValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.f15536a == j2) {
                return;
            }
            this.f15536a = j2;
            this.f15537b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f15543h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15543h = str;
                this.f15537b = true;
            }
        }

        public void i(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) || this.f15542g == j2) {
                return;
            }
            this.f15542g = j2;
            this.f15537b = true;
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || this.f15544i == str) {
                return;
            }
            if (str == null || !str.equals(this.f15543h)) {
                this.f15544i = str;
                this.f15537b = true;
            }
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String g2 = this.f15545j.f15510d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f15539d = jSONObject.optString("form_id");
                        this.f15536a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f15538c.b(jSONObject.getLong("flags"));
                        this.f15540e = jSONObject.optInt("init_res");
                        this.f15542g = jSONObject.optLong("acquire_ts_cost");
                        this.f15543h = jSONObject.optString("oid");
                        this.f15541f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f15541f.clear();
                                    return false;
                                }
                                this.f15541f.add(string);
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
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f15541f.contains(str)) {
                return;
            }
            this.f15541f.add(str);
            this.f15537b = true;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f15537b) {
                    try {
                        this.f15545j.f15510d.i("cache.dat", n().toString(), true);
                        this.f15537b = false;
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
                    jSONObject.put("form_id", this.f15539d);
                    jSONObject.put("lst_fe_ts", this.f15536a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f15538c.d());
                    jSONObject.put("init_res", this.f15540e);
                    jSONObject.put("acquire_ts_cost", this.f15542g);
                    jSONObject.put("oid", this.f15543h);
                    int size = this.f15541f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f15541f.get((size - min) + i2));
                        }
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
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
        this.f15511e = new e(this);
        this.f15513g = new ArrayList();
    }

    @Override // c.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15511e.b() : (String) invokeV.objValue;
    }

    @Override // c.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f15510d = this.f15477a.f(e());
            Context context = this.f15478b.f15482a;
            d dVar = new d(this);
            this.f15512f = dVar;
            this.f15511e.k();
            long currentTimeMillis = System.currentTimeMillis();
            if (!cVar.f15487a && Math.abs(currentTimeMillis - this.f15511e.f()) <= 604800000) {
                dVar.f15535c.set(true);
                return;
            }
            this.f15511e.g(currentTimeMillis);
            this.f15511e.d(4L, 124L);
            this.f15511e.i(0L);
            this.f15511e.m();
            this.f15478b.f15486e.submit(new b(this, new HandlerC0741a(this, Looper.getMainLooper(), dVar), context, dVar));
        }
    }

    @Override // c.a.r.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f15478b.f15485d.submit(new c(this, dVar));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f15513g) {
                j(dVar);
            }
            this.f15513g.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f15511e.b())) {
                dVar.a(this.f15511e.f15540e, null, bundle);
            } else {
                dVar.onResult(this.f15511e.b(), bundle);
            }
        }
    }
}
