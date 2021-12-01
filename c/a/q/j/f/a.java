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
/* loaded from: classes5.dex */
public class a extends c.a.q.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0742a f11511d;

    /* renamed from: e  reason: collision with root package name */
    public g f11512e;

    /* renamed from: f  reason: collision with root package name */
    public f f11513f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.c<String>> f11514g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f11515h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11516i;

    /* renamed from: c.a.q.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class HandlerC0746a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f11517b;

        /* renamed from: c.a.q.j.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0747a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC0746a f11518e;

            public RunnableC0747a(HandlerC0746a handlerC0746a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC0746a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11518e = handlerC0746a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f11518e.a.f11538c.get()) {
                    return;
                }
                this.f11518e.f11517b.f11512e.d(64L, 124L);
                this.f11518e.f11517b.f11512e.p();
                this.f11518e.f11517b.k();
                this.f11518e.a.f11538c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0746a(a aVar, Looper looper, f fVar) {
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
            this.f11517b = aVar;
            this.a = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f11517b.f11485b.f11489d.submit(new RunnableC0747a(this));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f11519e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f11520f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f11521g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f11522h;

        /* renamed from: c.a.q.j.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0748a extends h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f11523b;

            public C0748a(b bVar, long j2) {
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
                this.f11523b = bVar;
                this.a = j2;
            }

            @Override // c.a.q.j.f.a.h
            public void a(IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, idSupplier) == null) {
                    if (idSupplier.isSupported()) {
                        this.f11523b.f11522h.f11516i = true;
                    } else if (this.f11523b.f11522h.f11516i) {
                        return;
                    }
                    String oaid = idSupplier.getOAID();
                    this.f11523b.f11519e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f11523b;
                    bVar.f11522h.n(bVar.f11521g, oaid, elapsedRealtime - this.a);
                }
            }
        }

        /* renamed from: c.a.q.j.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0749b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f11524e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f11525f;

            public RunnableC0749b(b bVar, Throwable th) {
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
                this.f11525f = bVar;
                this.f11524e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f11525f.f11519e.removeMessages(0);
                    this.f11525f.f11522h.f11512e.k(Log.getStackTraceString(this.f11524e));
                    this.f11525f.f11522h.f11512e.p();
                    if (this.f11525f.f11521g.f11538c.get()) {
                        return;
                    }
                    this.f11525f.f11521g.f11538c.set(true);
                    this.f11525f.f11522h.k();
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
            this.f11522h = aVar;
            this.f11519e = handler;
            this.f11520f = context;
            this.f11521g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11519e.sendEmptyMessageDelayed(0, 50000L);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    if (!this.f11522h.f11515h) {
                        this.f11522h.f11515h = MdidSdkHelper.InitCert(this.f11520f, this.f11522h.i(this.f11520f, "msa/msa.pem"));
                    }
                    this.f11522h.m(this.f11521g, this.f11519e, this.f11522h.f11515h ? MdidSdkHelper.InitSdk(this.f11520f, false, new C0748a(this, elapsedRealtime)) : InfoCode.INIT_ERROR_CERT_ERROR, 0);
                } catch (Throwable th) {
                    this.f11522h.f11485b.f11489d.submit(new RunnableC0749b(this, th));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f11526e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f11527f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f11528g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f11529h;

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
            this.f11529h = aVar;
            this.f11526e = j2;
            this.f11527f = str;
            this.f11528g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f11529h.f11512e.g(this.f11526e);
                this.f11529h.f11512e.d(16L, 124L);
                this.f11529h.f11512e.o(this.f11527f);
                if (!TextUtils.isEmpty(this.f11527f) && !TextUtils.equals(this.f11527f, "00000000-0000-0000-0000-000000000000")) {
                    try {
                        String b2 = c.a.q.j.a.b("A10", new c.a.q.h.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f11527f.getBytes("UTF-8")));
                        this.f11529h.f11512e.h(b2);
                        this.f11529h.f11512e.e(b2);
                        this.f11529h.f11512e.d(32L, 124L);
                    } catch (Exception unused) {
                    }
                }
                this.f11529h.f11512e.p();
                if (this.f11528g.f11538c.get()) {
                    return;
                }
                this.f11529h.k();
                this.f11528g.f11538c.set(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f11530e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f11531f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Handler f11532g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f11533h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f11534i;

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
            this.f11534i = aVar;
            this.f11530e = i2;
            this.f11531f = fVar;
            this.f11532g = handler;
            this.f11533h = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f11530e;
                if (i2 == 1008612 || i2 == 1008616 || i2 == 1008611 || i2 == 1008615) {
                    if (!this.f11531f.f11538c.get()) {
                        this.f11531f.f11538c.set(true);
                        this.f11534i.k();
                    }
                    this.f11532g.removeMessages(this.f11533h);
                }
                this.f11534i.f11512e.c(this.f11530e);
                this.f11534i.f11512e.d(8L, 124L);
                this.f11534i.f11512e.p();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f11535e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11536f;

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
            this.f11536f = aVar;
            this.f11535e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f11536f.f11513f.f11538c.get()) {
                    this.f11536f.l(this.f11535e);
                } else {
                    this.f11536f.f11514g.add(this.f11535e);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Future<?> a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f11537b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f11538c;

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
            this.f11538c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes5.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11539b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.q.h.c.a.e f11540c;

        /* renamed from: d  reason: collision with root package name */
        public String f11541d;

        /* renamed from: e  reason: collision with root package name */
        public int f11542e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f11543f;

        /* renamed from: g  reason: collision with root package name */
        public long f11544g;

        /* renamed from: h  reason: collision with root package name */
        public String f11545h;

        /* renamed from: i  reason: collision with root package name */
        public String f11546i;

        /* renamed from: j  reason: collision with root package name */
        public String f11547j;

        /* renamed from: k  reason: collision with root package name */
        public final /* synthetic */ a f11548k;

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
            this.f11548k = aVar;
            this.f11539b = true;
            this.f11540c = new c.a.q.h.c.a.e();
            this.f11543f = new ArrayList<>();
        }

        public final JSONObject b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("form_id", this.f11541d);
                    jSONObject.put("lst_fe_ts", this.a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f11540c.d());
                    jSONObject.put("init_res", this.f11542e);
                    jSONObject.put("acquire_ts_cost", this.f11544g);
                    jSONObject.put("oid", this.f11545h);
                    jSONObject.put("sdk_version", this.f11546i);
                    int size = this.f11543f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f11543f.get((size - min) + i2));
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
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f11542e == i2) {
                return;
            }
            this.f11542e = i2;
            this.f11539b = true;
        }

        public void d(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f11540c.c(j2, j3)) {
                this.f11539b = true;
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f11543f.contains(str)) {
                return;
            }
            this.f11543f.add(str);
            this.f11539b = true;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f11541d : (String) invokeV.objValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.f11544g == j2) {
                return;
            }
            this.f11544g = j2;
            this.f11539b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f11541d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f11541d = str;
                this.f11539b = true;
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
            this.f11539b = true;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.f11547j == str) {
                return;
            }
            if (str == null || !str.equals(this.f11545h)) {
                this.f11547j = str;
                this.f11539b = true;
            }
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f11546i : (String) invokeV.objValue;
        }

        public void m(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.equals(this.f11546i, str)) {
                return;
            }
            this.f11546i = str;
            this.f11539b = true;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f11545h : (String) invokeV.objValue;
        }

        public void o(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (str2 = this.f11545h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f11545h = str;
                this.f11539b = true;
            }
        }

        public boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (this.f11539b) {
                    try {
                        this.f11548k.f11511d.i("cache.dat", b().toString(), true);
                        this.f11539b = false;
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
                String g2 = this.f11548k.f11511d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f11541d = jSONObject.optString("form_id");
                        this.a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f11540c.b(jSONObject.getLong("flags"));
                        this.f11542e = jSONObject.optInt("init_res");
                        this.f11544g = jSONObject.optLong("acquire_ts_cost");
                        this.f11545h = jSONObject.optString("oid");
                        this.f11546i = jSONObject.optString("sdk_version");
                        this.f11543f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f11543f.clear();
                                    return false;
                                }
                                this.f11543f.add(string);
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

    /* loaded from: classes5.dex */
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
        this.f11512e = new g(this);
        this.f11514g = new ArrayList();
        this.f11515h = false;
        this.f11516i = false;
    }

    @Override // c.a.q.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11512e.f() : (String) invokeV.objValue;
    }

    @Override // c.a.q.j.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f11511d = this.a.f(e());
            Context context = this.f11485b.a;
            f fVar = new f(this);
            this.f11513f = fVar;
            this.f11512e.q();
            long currentTimeMillis = System.currentTimeMillis();
            if (!bVar.a && !r(currentTimeMillis)) {
                fVar.f11538c.set(true);
                return;
            }
            this.f11512e.j(currentTimeMillis);
            this.f11512e.d(4L, 124L);
            this.f11512e.g(0L);
            this.f11512e.m("1.0.26");
            this.f11512e.p();
            this.f11485b.f11490e.submit(new b(this, new HandlerC0746a(this, Looper.getMainLooper(), fVar), context, fVar));
        }
    }

    @Override // c.a.q.j.a
    public void g(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f11485b.f11489d.submit(new e(this, cVar));
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
            for (a.c<String> cVar : this.f11514g) {
                l(cVar);
            }
            this.f11514g.clear();
        }
    }

    public final void l(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f11512e.f())) {
                cVar.a(this.f11512e.f11542e, null, bundle);
            } else {
                cVar.onResult(this.f11512e.f(), bundle);
            }
        }
    }

    public final void m(f fVar, Handler handler, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048582, this, fVar, handler, i2, i3) == null) {
            fVar.a = this.f11485b.f11489d.submit(new d(this, i2, fVar, handler, i3));
        }
    }

    public final void n(f fVar, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{fVar, str, Long.valueOf(j2)}) == null) {
            fVar.f11537b = this.f11485b.f11489d.submit(new c(this, j2, str, fVar));
        }
    }

    public final boolean r(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) ? Math.abs(j2 - this.f11512e.i()) > 604800000 || (!TextUtils.equals(this.f11512e.l(), "1.0.26") && TextUtils.isEmpty(this.f11512e.n())) : invokeJ.booleanValue;
    }
}
