package c.a.r.j.f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import c.a.r.h.d.a;
import c.a.r.j.a;
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
/* loaded from: classes.dex */
public class a extends c.a.r.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0241a f5107d;

    /* renamed from: e  reason: collision with root package name */
    public g f5108e;

    /* renamed from: f  reason: collision with root package name */
    public f f5109f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.c<String>> f5110g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5111h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5112i;

    /* renamed from: c.a.r.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0245a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5113b;

        /* renamed from: c.a.r.j.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0246a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC0245a f5114e;

            public RunnableC0246a(HandlerC0245a handlerC0245a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC0245a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5114e = handlerC0245a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5114e.a.f5134c.get()) {
                    return;
                }
                this.f5114e.f5113b.f5108e.d(64L, 124L);
                this.f5114e.f5113b.f5108e.p();
                this.f5114e.f5113b.k();
                this.f5114e.a.f5134c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0245a(a aVar, Looper looper, f fVar) {
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
            this.f5113b = aVar;
            this.a = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f5113b.f5081b.f5085d.submit(new RunnableC0246a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f5115e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f5116f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f5117g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f5118h;

        /* renamed from: c.a.r.j.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0247a extends h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f5119b;

            public C0247a(b bVar, long j2) {
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
                this.f5119b = bVar;
                this.a = j2;
            }

            @Override // c.a.r.j.f.a.h
            public void a(IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, idSupplier) == null) {
                    if (idSupplier.isSupported()) {
                        this.f5119b.f5118h.f5112i = true;
                    } else if (this.f5119b.f5118h.f5112i) {
                        return;
                    }
                    String oaid = idSupplier.getOAID();
                    this.f5119b.f5115e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f5119b;
                    bVar.f5118h.n(bVar.f5117g, oaid, elapsedRealtime - this.a);
                }
            }
        }

        /* renamed from: c.a.r.j.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0248b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f5120e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f5121f;

            public RunnableC0248b(b bVar, Throwable th) {
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
                this.f5121f = bVar;
                this.f5120e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5121f.f5115e.removeMessages(0);
                    this.f5121f.f5118h.f5108e.k(Log.getStackTraceString(this.f5120e));
                    this.f5121f.f5118h.f5108e.p();
                    if (this.f5121f.f5117g.f5134c.get()) {
                        return;
                    }
                    this.f5121f.f5117g.f5134c.set(true);
                    this.f5121f.f5118h.k();
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
            this.f5118h = aVar;
            this.f5115e = handler;
            this.f5116f = context;
            this.f5117g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5115e.sendEmptyMessageDelayed(0, 50000L);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    if (!this.f5118h.f5111h) {
                        this.f5118h.f5111h = MdidSdkHelper.InitCert(this.f5116f, this.f5118h.i(this.f5116f, "msa/msa.pem"));
                    }
                    this.f5118h.m(this.f5117g, this.f5115e, this.f5118h.f5111h ? MdidSdkHelper.InitSdk(this.f5116f, false, new C0247a(this, elapsedRealtime)) : InfoCode.INIT_ERROR_CERT_ERROR, 0);
                } catch (Throwable th) {
                    this.f5118h.f5081b.f5085d.submit(new RunnableC0248b(this, th));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f5122e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5123f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f5124g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f5125h;

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
            this.f5125h = aVar;
            this.f5122e = j2;
            this.f5123f = str;
            this.f5124g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5125h.f5108e.g(this.f5122e);
                this.f5125h.f5108e.d(16L, 124L);
                this.f5125h.f5108e.o(this.f5123f);
                if (!TextUtils.isEmpty(this.f5123f) && !TextUtils.equals(this.f5123f, "00000000-0000-0000-0000-000000000000")) {
                    try {
                        String b2 = c.a.r.j.a.b("A10", new c.a.r.h.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f5123f.getBytes("UTF-8")));
                        this.f5125h.f5108e.h(b2);
                        this.f5125h.f5108e.e(b2);
                        this.f5125h.f5108e.d(32L, 124L);
                    } catch (Exception unused) {
                    }
                }
                this.f5125h.f5108e.p();
                if (this.f5124g.f5134c.get()) {
                    return;
                }
                this.f5125h.k();
                this.f5124g.f5134c.set(true);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f5126e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f5127f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Handler f5128g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f5129h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f5130i;

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
            this.f5130i = aVar;
            this.f5126e = i2;
            this.f5127f = fVar;
            this.f5128g = handler;
            this.f5129h = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f5126e;
                if (i2 == 1008612 || i2 == 1008616 || i2 == 1008611 || i2 == 1008615) {
                    if (!this.f5127f.f5134c.get()) {
                        this.f5127f.f5134c.set(true);
                        this.f5130i.k();
                    }
                    this.f5128g.removeMessages(this.f5129h);
                }
                this.f5130i.f5108e.c(this.f5126e);
                this.f5130i.f5108e.d(8L, 124L);
                this.f5130i.f5108e.p();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f5131e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5132f;

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
            this.f5132f = aVar;
            this.f5131e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f5132f.f5109f.f5134c.get()) {
                    this.f5132f.l(this.f5131e);
                } else {
                    this.f5132f.f5110g.add(this.f5131e);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Future<?> a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f5133b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f5134c;

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
            this.f5134c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5135b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.r.h.c.a.e f5136c;

        /* renamed from: d  reason: collision with root package name */
        public String f5137d;

        /* renamed from: e  reason: collision with root package name */
        public int f5138e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f5139f;

        /* renamed from: g  reason: collision with root package name */
        public long f5140g;

        /* renamed from: h  reason: collision with root package name */
        public String f5141h;

        /* renamed from: i  reason: collision with root package name */
        public String f5142i;

        /* renamed from: j  reason: collision with root package name */
        public String f5143j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ a f5144k;

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
            this.f5144k = aVar;
            this.f5135b = true;
            this.f5136c = new c.a.r.h.c.a.e();
            this.f5139f = new ArrayList<>();
        }

        public final JSONObject b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("form_id", this.f5137d);
                    jSONObject.put("lst_fe_ts", this.a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f5136c.d());
                    jSONObject.put("init_res", this.f5138e);
                    jSONObject.put("acquire_ts_cost", this.f5140g);
                    jSONObject.put("oid", this.f5141h);
                    jSONObject.put("sdk_version", this.f5142i);
                    int size = this.f5139f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f5139f.get((size - min) + i2));
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
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f5138e == i2) {
                return;
            }
            this.f5138e = i2;
            this.f5135b = true;
        }

        public void d(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f5136c.c(j2, j3)) {
                this.f5135b = true;
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f5139f.contains(str)) {
                return;
            }
            this.f5139f.add(str);
            this.f5135b = true;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5137d : (String) invokeV.objValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.f5140g == j2) {
                return;
            }
            this.f5140g = j2;
            this.f5135b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f5137d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f5137d = str;
                this.f5135b = true;
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
            this.f5135b = true;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.f5143j == str) {
                return;
            }
            if (str == null || !str.equals(this.f5141h)) {
                this.f5143j = str;
                this.f5135b = true;
            }
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f5142i : (String) invokeV.objValue;
        }

        public void m(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.equals(this.f5142i, str)) {
                return;
            }
            this.f5142i = str;
            this.f5135b = true;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f5141h : (String) invokeV.objValue;
        }

        public void o(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (str2 = this.f5141h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f5141h = str;
                this.f5135b = true;
            }
        }

        public boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (this.f5135b) {
                    try {
                        this.f5144k.f5107d.i("cache.dat", b().toString(), true);
                        this.f5135b = false;
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
                String g2 = this.f5144k.f5107d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f5137d = jSONObject.optString("form_id");
                        this.a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f5136c.b(jSONObject.getLong("flags"));
                        this.f5138e = jSONObject.optInt("init_res");
                        this.f5140g = jSONObject.optLong("acquire_ts_cost");
                        this.f5141h = jSONObject.optString("oid");
                        this.f5142i = jSONObject.optString("sdk_version");
                        this.f5139f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f5139f.clear();
                                    return false;
                                }
                                this.f5139f.add(string);
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

    /* loaded from: classes.dex */
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
        this.f5108e = new g(this);
        this.f5110g = new ArrayList();
        this.f5111h = false;
        this.f5112i = false;
    }

    @Override // c.a.r.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5108e.f() : (String) invokeV.objValue;
    }

    @Override // c.a.r.j.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f5107d = this.a.f(e());
            Context context = this.f5081b.a;
            f fVar = new f(this);
            this.f5109f = fVar;
            this.f5108e.q();
            long currentTimeMillis = System.currentTimeMillis();
            if (!bVar.a && !r(currentTimeMillis)) {
                fVar.f5134c.set(true);
                return;
            }
            this.f5108e.j(currentTimeMillis);
            this.f5108e.d(4L, 124L);
            this.f5108e.g(0L);
            this.f5108e.m("1.0.26");
            this.f5108e.p();
            this.f5081b.f5086e.submit(new b(this, new HandlerC0245a(this, Looper.getMainLooper(), fVar), context, fVar));
        }
    }

    @Override // c.a.r.j.a
    public void g(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f5081b.f5085d.submit(new e(this, cVar));
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
            for (a.c<String> cVar : this.f5110g) {
                l(cVar);
            }
            this.f5110g.clear();
        }
    }

    public final void l(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f5108e.f())) {
                cVar.a(this.f5108e.f5138e, null, bundle);
            } else {
                cVar.onResult(this.f5108e.f(), bundle);
            }
        }
    }

    public final void m(f fVar, Handler handler, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048582, this, fVar, handler, i2, i3) == null) {
            fVar.a = this.f5081b.f5085d.submit(new d(this, i2, fVar, handler, i3));
        }
    }

    public final void n(f fVar, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{fVar, str, Long.valueOf(j2)}) == null) {
            fVar.f5133b = this.f5081b.f5085d.submit(new c(this, j2, str, fVar));
        }
    }

    public final boolean r(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) ? Math.abs(j2 - this.f5108e.i()) > 604800000 || (!TextUtils.equals(this.f5108e.l(), "1.0.26") && TextUtils.isEmpty(this.f5108e.n())) : invokeJ.booleanValue;
    }
}
