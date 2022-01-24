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
    public a.C0259a f5142d;

    /* renamed from: e  reason: collision with root package name */
    public g f5143e;

    /* renamed from: f  reason: collision with root package name */
    public f f5144f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.c<String>> f5145g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f5146h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5147i;

    /* renamed from: c.a.r.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class HandlerC0263a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f5148b;

        /* renamed from: c.a.r.j.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0264a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC0263a f5149e;

            public RunnableC0264a(HandlerC0263a handlerC0263a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC0263a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5149e = handlerC0263a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f5149e.a.f5169c.get()) {
                    return;
                }
                this.f5149e.f5148b.f5143e.d(64L, 124L);
                this.f5149e.f5148b.f5143e.p();
                this.f5149e.f5148b.k();
                this.f5149e.a.f5169c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0263a(a aVar, Looper looper, f fVar) {
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
            this.f5148b = aVar;
            this.a = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f5148b.f5116b.f5120d.submit(new RunnableC0264a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f5150e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f5151f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f5152g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f5153h;

        /* renamed from: c.a.r.j.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0265a extends h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f5154b;

            public C0265a(b bVar, long j2) {
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
                this.f5154b = bVar;
                this.a = j2;
            }

            @Override // c.a.r.j.f.a.h
            public void a(IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, idSupplier) == null) {
                    if (idSupplier.isSupported()) {
                        this.f5154b.f5153h.f5147i = true;
                    } else if (this.f5154b.f5153h.f5147i) {
                        return;
                    }
                    String oaid = idSupplier.getOAID();
                    this.f5154b.f5150e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f5154b;
                    bVar.f5153h.n(bVar.f5152g, oaid, elapsedRealtime - this.a);
                }
            }
        }

        /* renamed from: c.a.r.j.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0266b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f5155e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f5156f;

            public RunnableC0266b(b bVar, Throwable th) {
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
                this.f5156f = bVar;
                this.f5155e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f5156f.f5150e.removeMessages(0);
                    this.f5156f.f5153h.f5143e.k(Log.getStackTraceString(this.f5155e));
                    this.f5156f.f5153h.f5143e.p();
                    if (this.f5156f.f5152g.f5169c.get()) {
                        return;
                    }
                    this.f5156f.f5152g.f5169c.set(true);
                    this.f5156f.f5153h.k();
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
            this.f5153h = aVar;
            this.f5150e = handler;
            this.f5151f = context;
            this.f5152g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5150e.sendEmptyMessageDelayed(0, 50000L);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    if (!this.f5153h.f5146h) {
                        this.f5153h.f5146h = MdidSdkHelper.InitCert(this.f5151f, this.f5153h.i(this.f5151f, "msa/msa.pem"));
                    }
                    this.f5153h.m(this.f5152g, this.f5150e, this.f5153h.f5146h ? MdidSdkHelper.InitSdk(this.f5151f, false, new C0265a(this, elapsedRealtime)) : InfoCode.INIT_ERROR_CERT_ERROR, 0);
                } catch (Throwable th) {
                    this.f5153h.f5116b.f5120d.submit(new RunnableC0266b(this, th));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f5157e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f5158f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f5159g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f5160h;

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
            this.f5160h = aVar;
            this.f5157e = j2;
            this.f5158f = str;
            this.f5159g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5160h.f5143e.g(this.f5157e);
                this.f5160h.f5143e.d(16L, 124L);
                this.f5160h.f5143e.o(this.f5158f);
                if (!TextUtils.isEmpty(this.f5158f) && !TextUtils.equals(this.f5158f, "00000000-0000-0000-0000-000000000000")) {
                    try {
                        String b2 = c.a.r.j.a.b("A10", new c.a.r.h.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f5158f.getBytes("UTF-8")));
                        this.f5160h.f5143e.h(b2);
                        this.f5160h.f5143e.e(b2);
                        this.f5160h.f5143e.d(32L, 124L);
                    } catch (Exception unused) {
                    }
                }
                this.f5160h.f5143e.p();
                if (this.f5159g.f5169c.get()) {
                    return;
                }
                this.f5160h.k();
                this.f5159g.f5169c.set(true);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f5161e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f5162f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Handler f5163g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f5164h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f5165i;

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
            this.f5165i = aVar;
            this.f5161e = i2;
            this.f5162f = fVar;
            this.f5163g = handler;
            this.f5164h = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f5161e;
                if (i2 == 1008612 || i2 == 1008616 || i2 == 1008611 || i2 == 1008615) {
                    if (!this.f5162f.f5169c.get()) {
                        this.f5162f.f5169c.set(true);
                        this.f5165i.k();
                    }
                    this.f5163g.removeMessages(this.f5164h);
                }
                this.f5165i.f5143e.c(this.f5161e);
                this.f5165i.f5143e.d(8L, 124L);
                this.f5165i.f5143e.p();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f5166e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5167f;

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
            this.f5167f = aVar;
            this.f5166e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f5167f.f5144f.f5169c.get()) {
                    this.f5167f.l(this.f5166e);
                } else {
                    this.f5167f.f5145g.add(this.f5166e);
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
        public Future<?> f5168b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f5169c;

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
            this.f5169c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5170b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.r.h.c.a.e f5171c;

        /* renamed from: d  reason: collision with root package name */
        public String f5172d;

        /* renamed from: e  reason: collision with root package name */
        public int f5173e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f5174f;

        /* renamed from: g  reason: collision with root package name */
        public long f5175g;

        /* renamed from: h  reason: collision with root package name */
        public String f5176h;

        /* renamed from: i  reason: collision with root package name */
        public String f5177i;

        /* renamed from: j  reason: collision with root package name */
        public String f5178j;
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
            this.f5170b = true;
            this.f5171c = new c.a.r.h.c.a.e();
            this.f5174f = new ArrayList<>();
        }

        public final JSONObject b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("form_id", this.f5172d);
                    jSONObject.put("lst_fe_ts", this.a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f5171c.d());
                    jSONObject.put("init_res", this.f5173e);
                    jSONObject.put("acquire_ts_cost", this.f5175g);
                    jSONObject.put("oid", this.f5176h);
                    jSONObject.put("sdk_version", this.f5177i);
                    int size = this.f5174f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f5174f.get((size - min) + i2));
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
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f5173e == i2) {
                return;
            }
            this.f5173e = i2;
            this.f5170b = true;
        }

        public void d(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f5171c.c(j2, j3)) {
                this.f5170b = true;
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f5174f.contains(str)) {
                return;
            }
            this.f5174f.add(str);
            this.f5170b = true;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f5172d : (String) invokeV.objValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.f5175g == j2) {
                return;
            }
            this.f5175g = j2;
            this.f5170b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f5172d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f5172d = str;
                this.f5170b = true;
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
            this.f5170b = true;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.f5178j == str) {
                return;
            }
            if (str == null || !str.equals(this.f5176h)) {
                this.f5178j = str;
                this.f5170b = true;
            }
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f5177i : (String) invokeV.objValue;
        }

        public void m(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.equals(this.f5177i, str)) {
                return;
            }
            this.f5177i = str;
            this.f5170b = true;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f5176h : (String) invokeV.objValue;
        }

        public void o(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (str2 = this.f5176h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f5176h = str;
                this.f5170b = true;
            }
        }

        public boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (this.f5170b) {
                    try {
                        this.k.f5142d.i("cache.dat", b().toString(), true);
                        this.f5170b = false;
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
                String g2 = this.k.f5142d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f5172d = jSONObject.optString("form_id");
                        this.a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f5171c.b(jSONObject.getLong("flags"));
                        this.f5173e = jSONObject.optInt("init_res");
                        this.f5175g = jSONObject.optLong("acquire_ts_cost");
                        this.f5176h = jSONObject.optString("oid");
                        this.f5177i = jSONObject.optString("sdk_version");
                        this.f5174f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f5174f.clear();
                                    return false;
                                }
                                this.f5174f.add(string);
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
        this.f5143e = new g(this);
        this.f5145g = new ArrayList();
        this.f5146h = false;
        this.f5147i = false;
    }

    @Override // c.a.r.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5143e.f() : (String) invokeV.objValue;
    }

    @Override // c.a.r.j.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f5142d = this.a.f(e());
            Context context = this.f5116b.a;
            f fVar = new f(this);
            this.f5144f = fVar;
            this.f5143e.q();
            long currentTimeMillis = System.currentTimeMillis();
            if (!bVar.a && !r(currentTimeMillis)) {
                fVar.f5169c.set(true);
                return;
            }
            this.f5143e.j(currentTimeMillis);
            this.f5143e.d(4L, 124L);
            this.f5143e.g(0L);
            this.f5143e.m("1.0.26");
            this.f5143e.p();
            this.f5116b.f5121e.submit(new b(this, new HandlerC0263a(this, Looper.getMainLooper(), fVar), context, fVar));
        }
    }

    @Override // c.a.r.j.a
    public void g(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f5116b.f5120d.submit(new e(this, cVar));
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
            for (a.c<String> cVar : this.f5145g) {
                l(cVar);
            }
            this.f5145g.clear();
        }
    }

    public final void l(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f5143e.f())) {
                cVar.a(this.f5143e.f5173e, null, bundle);
            } else {
                cVar.onResult(this.f5143e.f(), bundle);
            }
        }
    }

    public final void m(f fVar, Handler handler, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048582, this, fVar, handler, i2, i3) == null) {
            fVar.a = this.f5116b.f5120d.submit(new d(this, i2, fVar, handler, i3));
        }
    }

    public final void n(f fVar, String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{fVar, str, Long.valueOf(j2)}) == null) {
            fVar.f5168b = this.f5116b.f5120d.submit(new c(this, j2, str, fVar));
        }
    }

    public final boolean r(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2)) == null) ? Math.abs(j2 - this.f5143e.i()) > 604800000 || (!TextUtils.equals(this.f5143e.l(), "1.0.26") && TextUtils.isEmpty(this.f5143e.n())) : invokeJ.booleanValue;
    }
}
