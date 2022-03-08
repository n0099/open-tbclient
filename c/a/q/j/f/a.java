package c.a.q.j.f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.q.h.d.a;
import c.a.q.j.a;
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
public class a extends c.a.q.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0801a f11733d;

    /* renamed from: e  reason: collision with root package name */
    public g f11734e;

    /* renamed from: f  reason: collision with root package name */
    public f f11735f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.c<String>> f11736g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11737h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11738i;

    /* renamed from: c.a.q.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class HandlerC0805a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f11739b;

        /* renamed from: c.a.q.j.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0806a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC0805a f11740e;

            public RunnableC0806a(HandlerC0805a handlerC0805a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC0805a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11740e = handlerC0805a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11740e.a.f11760c.get()) {
                    return;
                }
                this.f11740e.f11739b.f11734e.d(64L, 124L);
                this.f11740e.f11739b.f11734e.p();
                this.f11740e.f11739b.k();
                this.f11740e.a.f11760c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0805a(a aVar, Looper looper, f fVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, looper, fVar};
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
            this.f11739b = aVar;
            this.a = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f11739b.f11707b.f11711d.submit(new RunnableC0806a(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f11741e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f11742f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f11743g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f11744h;

        /* renamed from: c.a.q.j.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0807a extends h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f11745b;

            public C0807a(b bVar, long j2) {
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
                this.f11745b = bVar;
                this.a = j2;
            }

            @Override // c.a.q.j.f.a.h
            public void a(IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, idSupplier) == null) {
                    if (idSupplier.isSupported()) {
                        this.f11745b.f11744h.f11738i = true;
                    } else if (this.f11745b.f11744h.f11738i) {
                        return;
                    }
                    String oaid = idSupplier.getOAID();
                    this.f11745b.f11741e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f11745b;
                    bVar.f11744h.n(bVar.f11743g, oaid, elapsedRealtime - this.a);
                }
            }
        }

        /* renamed from: c.a.q.j.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0808b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f11746e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f11747f;

            public RunnableC0808b(b bVar, Throwable th) {
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
                this.f11747f = bVar;
                this.f11746e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f11747f.f11741e.removeMessages(0);
                    this.f11747f.f11744h.f11734e.k(Log.getStackTraceString(this.f11746e));
                    this.f11747f.f11744h.f11734e.p();
                    if (this.f11747f.f11743g.f11760c.get()) {
                        return;
                    }
                    this.f11747f.f11743g.f11760c.set(true);
                    this.f11747f.f11744h.k();
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11744h = aVar;
            this.f11741e = handler;
            this.f11742f = context;
            this.f11743g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11741e.sendEmptyMessageDelayed(0, 50000L);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    if (!this.f11744h.f11737h) {
                        this.f11744h.f11737h = MdidSdkHelper.InitCert(this.f11742f, this.f11744h.i(this.f11742f, "msa/msa.pem"));
                    }
                    this.f11744h.m(this.f11743g, this.f11741e, this.f11744h.f11737h ? MdidSdkHelper.InitSdk(this.f11742f, false, new C0807a(this, elapsedRealtime)) : InfoCode.INIT_ERROR_CERT_ERROR, 0);
                } catch (Throwable th) {
                    this.f11744h.f11707b.f11711d.submit(new RunnableC0808b(this, th));
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f11748e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11749f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f11750g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f11751h;

        public c(a aVar, long j2, String str, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2), str, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11751h = aVar;
            this.f11748e = j2;
            this.f11749f = str;
            this.f11750g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11751h.f11734e.g(this.f11748e);
                this.f11751h.f11734e.d(16L, 124L);
                this.f11751h.f11734e.o(this.f11749f);
                if (!TextUtils.isEmpty(this.f11749f) && !TextUtils.equals(this.f11749f, "00000000-0000-0000-0000-000000000000")) {
                    try {
                        String b2 = c.a.q.j.a.b("A10", new c.a.q.h.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f11749f.getBytes("UTF-8")));
                        this.f11751h.f11734e.h(b2);
                        this.f11751h.f11734e.e(b2);
                        this.f11751h.f11734e.d(32L, 124L);
                    } catch (Exception unused) {
                    }
                }
                this.f11751h.f11734e.p();
                if (this.f11750g.f11760c.get()) {
                    return;
                }
                this.f11751h.k();
                this.f11750g.f11760c.set(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f11752e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f11753f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Handler f11754g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f11755h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f11756i;

        public d(a aVar, int i2, f fVar, Handler handler, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), fVar, handler, Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11756i = aVar;
            this.f11752e = i2;
            this.f11753f = fVar;
            this.f11754g = handler;
            this.f11755h = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f11752e;
                if (i2 == 1008612 || i2 == 1008616 || i2 == 1008611 || i2 == 1008615) {
                    if (!this.f11753f.f11760c.get()) {
                        this.f11753f.f11760c.set(true);
                        this.f11756i.k();
                    }
                    this.f11754g.removeMessages(this.f11755h);
                }
                this.f11756i.f11734e.c(this.f11752e);
                this.f11756i.f11734e.d(8L, 124L);
                this.f11756i.f11734e.p();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f11757e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11758f;

        public e(a aVar, a.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f11758f = aVar;
            this.f11757e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11758f.f11735f.f11760c.get()) {
                    this.f11758f.l(this.f11757e);
                } else {
                    this.f11758f.f11736g.add(this.f11757e);
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
        public Future<?> f11759b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f11760c;

        public f(a aVar) {
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
            this.f11760c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes2.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11761b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.q.h.c.a.e f11762c;

        /* renamed from: d  reason: collision with root package name */
        public String f11763d;

        /* renamed from: e  reason: collision with root package name */
        public int f11764e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f11765f;

        /* renamed from: g  reason: collision with root package name */
        public long f11766g;

        /* renamed from: h  reason: collision with root package name */
        public String f11767h;

        /* renamed from: i  reason: collision with root package name */
        public String f11768i;

        /* renamed from: j  reason: collision with root package name */
        public String f11769j;
        public final /* synthetic */ a k;

        public g(a aVar) {
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
            this.k = aVar;
            this.f11761b = true;
            this.f11762c = new c.a.q.h.c.a.e();
            this.f11765f = new ArrayList<>();
        }

        public final JSONObject b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("form_id", this.f11763d);
                    jSONObject.put("lst_fe_ts", this.a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f11762c.d());
                    jSONObject.put("init_res", this.f11764e);
                    jSONObject.put("acquire_ts_cost", this.f11766g);
                    jSONObject.put("oid", this.f11767h);
                    jSONObject.put("sdk_version", this.f11768i);
                    int size = this.f11765f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f11765f.get((size - min) + i2));
                        }
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f11764e == i2) {
                return;
            }
            this.f11764e = i2;
            this.f11761b = true;
        }

        public void d(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f11762c.c(j2, j3)) {
                this.f11761b = true;
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f11765f.contains(str)) {
                return;
            }
            this.f11765f.add(str);
            this.f11761b = true;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11763d : (String) invokeV.objValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.f11766g == j2) {
                return;
            }
            this.f11766g = j2;
            this.f11761b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f11763d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f11763d = str;
                this.f11761b = true;
            }
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.longValue;
        }

        public void j(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) || this.a == j2) {
                return;
            }
            this.a = j2;
            this.f11761b = true;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.f11769j == str) {
                return;
            }
            if (str == null || !str.equals(this.f11767h)) {
                this.f11769j = str;
                this.f11761b = true;
            }
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f11768i : (String) invokeV.objValue;
        }

        public void m(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.equals(this.f11768i, str)) {
                return;
            }
            this.f11768i = str;
            this.f11761b = true;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f11767h : (String) invokeV.objValue;
        }

        public void o(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (str2 = this.f11767h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f11767h = str;
                this.f11761b = true;
            }
        }

        public boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (this.f11761b) {
                    try {
                        this.k.f11733d.i("cache.dat", b().toString(), true);
                        this.f11761b = false;
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
                String g2 = this.k.f11733d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f11763d = jSONObject.optString("form_id");
                        this.a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f11762c.b(jSONObject.getLong("flags"));
                        this.f11764e = jSONObject.optInt("init_res");
                        this.f11766g = jSONObject.optLong("acquire_ts_cost");
                        this.f11767h = jSONObject.optString("oid");
                        this.f11768i = jSONObject.optString("sdk_version");
                        this.f11765f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f11765f.clear();
                                    return false;
                                }
                                this.f11765f.add(string);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11734e = new g(this);
        this.f11736g = new ArrayList();
        this.f11737h = false;
        this.f11738i = false;
    }

    @Override // c.a.q.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11734e.f() : (String) invokeV.objValue;
    }

    @Override // c.a.q.j.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f11733d = this.a.f(e());
            Context context = this.f11707b.a;
            f fVar = new f(this);
            this.f11735f = fVar;
            this.f11734e.q();
            long currentTimeMillis = System.currentTimeMillis();
            if (!bVar.a && !r(currentTimeMillis)) {
                fVar.f11760c.set(true);
                return;
            }
            this.f11734e.j(currentTimeMillis);
            this.f11734e.d(4L, 124L);
            this.f11734e.g(0L);
            this.f11734e.m("1.0.26");
            this.f11734e.p();
            this.f11707b.f11712e.submit(new b(this, new HandlerC0805a(this, Looper.getMainLooper(), fVar), context, fVar));
        }
    }

    @Override // c.a.q.j.a
    public void g(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f11707b.f11711d.submit(new e(this, cVar));
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
            for (a.c<String> cVar : this.f11736g) {
                l(cVar);
            }
            this.f11736g.clear();
        }
    }

    public final void l(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f11734e.f())) {
                cVar.a(this.f11734e.f11764e, null, bundle);
            } else {
                cVar.onResult(this.f11734e.f(), bundle);
            }
        }
    }

    public final void m(f fVar, Handler handler, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048582, this, fVar, handler, i2, i3) == null) {
            fVar.a = this.f11707b.f11711d.submit(new d(this, i2, fVar, handler, i3));
        }
    }

    public final void n(f fVar, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{fVar, str, Long.valueOf(j2)}) == null) {
            fVar.f11759b = this.f11707b.f11711d.submit(new c(this, j2, str, fVar));
        }
    }

    public final boolean r(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) ? Math.abs(j2 - this.f11734e.i()) > 604800000 || (!TextUtils.equals(this.f11734e.l(), "1.0.26") && TextUtils.isEmpty(this.f11734e.n())) : invokeJ.booleanValue;
    }
}
