package b.a.r.j.f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import b.a.r.h.d.a;
import b.a.r.j.a;
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
/* loaded from: classes4.dex */
public class a extends b.a.r.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0774a f15415d;

    /* renamed from: e  reason: collision with root package name */
    public g f15416e;

    /* renamed from: f  reason: collision with root package name */
    public f f15417f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.c<String>> f15418g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f15419h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f15420i;

    /* renamed from: b.a.r.j.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class HandlerC0778a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f15421a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f15422b;

        /* renamed from: b.a.r.j.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0779a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC0778a f15423e;

            public RunnableC0779a(HandlerC0778a handlerC0778a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC0778a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15423e = handlerC0778a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15423e.f15421a.f15445c.get()) {
                    return;
                }
                this.f15423e.f15422b.f15416e.d(64L, 124L);
                this.f15423e.f15422b.f15416e.p();
                this.f15423e.f15422b.k();
                this.f15423e.f15421a.f15445c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0778a(a aVar, Looper looper, f fVar) {
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
            this.f15422b = aVar;
            this.f15421a = fVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f15422b.f15383b.f15388d.submit(new RunnableC0779a(this));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f15424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f15425f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f15426g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f15427h;

        /* renamed from: b.a.r.j.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0780a extends h {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f15428a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f15429b;

            public C0780a(b bVar, long j) {
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
                this.f15429b = bVar;
                this.f15428a = j;
            }

            @Override // b.a.r.j.f.a.h
            public void a(IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, idSupplier) == null) {
                    if (idSupplier.isSupported()) {
                        this.f15429b.f15427h.f15420i = true;
                    } else if (this.f15429b.f15427h.f15420i) {
                        return;
                    }
                    String oaid = idSupplier.getOAID();
                    this.f15429b.f15424e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f15429b;
                    bVar.f15427h.n(bVar.f15426g, oaid, elapsedRealtime - this.f15428a);
                }
            }
        }

        /* renamed from: b.a.r.j.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0781b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f15430e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f15431f;

            public RunnableC0781b(b bVar, Throwable th) {
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
                this.f15431f = bVar;
                this.f15430e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f15431f.f15424e.removeMessages(0);
                    this.f15431f.f15427h.f15416e.k(Log.getStackTraceString(this.f15430e));
                    this.f15431f.f15427h.f15416e.p();
                    if (this.f15431f.f15426g.f15445c.get()) {
                        return;
                    }
                    this.f15431f.f15426g.f15445c.set(true);
                    this.f15431f.f15427h.k();
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
            this.f15427h = aVar;
            this.f15424e = handler;
            this.f15425f = context;
            this.f15426g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15424e.sendEmptyMessageDelayed(0, 50000L);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                try {
                    if (!this.f15427h.f15419h) {
                        this.f15427h.f15419h = MdidSdkHelper.InitCert(this.f15425f, this.f15427h.i(this.f15425f, "msa/msa.pem"));
                    }
                    this.f15427h.m(this.f15426g, this.f15424e, this.f15427h.f15419h ? MdidSdkHelper.InitSdk(this.f15425f, false, new C0780a(this, elapsedRealtime)) : InfoCode.INIT_ERROR_CERT_ERROR, 0);
                } catch (Throwable th) {
                    this.f15427h.f15383b.f15388d.submit(new RunnableC0781b(this, th));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f15432e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f15433f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f15434g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f15435h;

        public c(a aVar, long j, String str, f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j), str, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15435h = aVar;
            this.f15432e = j;
            this.f15433f = str;
            this.f15434g = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15435h.f15416e.g(this.f15432e);
                this.f15435h.f15416e.d(16L, 124L);
                this.f15435h.f15416e.o(this.f15433f);
                if (!TextUtils.isEmpty(this.f15433f) && !TextUtils.equals(this.f15433f, "00000000-0000-0000-0000-000000000000")) {
                    try {
                        String b2 = b.a.r.j.a.b("A10", new b.a.r.h.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f15433f.getBytes("UTF-8")));
                        this.f15435h.f15416e.h(b2);
                        this.f15435h.f15416e.e(b2);
                        this.f15435h.f15416e.d(32L, 124L);
                    } catch (Exception unused) {
                    }
                }
                this.f15435h.f15416e.p();
                if (this.f15434g.f15445c.get()) {
                    return;
                }
                this.f15435h.k();
                this.f15434g.f15445c.set(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f15436e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ f f15437f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Handler f15438g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f15439h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f15440i;

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
            this.f15440i = aVar;
            this.f15436e = i2;
            this.f15437f = fVar;
            this.f15438g = handler;
            this.f15439h = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i2 = this.f15436e;
                if (i2 == 1008612 || i2 == 1008616 || i2 == 1008611 || i2 == 1008615) {
                    if (!this.f15437f.f15445c.get()) {
                        this.f15437f.f15445c.set(true);
                        this.f15440i.k();
                    }
                    this.f15438g.removeMessages(this.f15439h);
                }
                this.f15440i.f15416e.c(this.f15436e);
                this.f15440i.f15416e.d(8L, 124L);
                this.f15440i.f15416e.p();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.c f15441e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15442f;

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
            this.f15442f = aVar;
            this.f15441e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f15442f.f15417f.f15445c.get()) {
                    this.f15442f.l(this.f15441e);
                } else {
                    this.f15442f.f15418g.add(this.f15441e);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f15443a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f15444b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f15445c;

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
            this.f15445c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes4.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15446a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15447b;

        /* renamed from: c  reason: collision with root package name */
        public b.a.r.h.c.a.e f15448c;

        /* renamed from: d  reason: collision with root package name */
        public String f15449d;

        /* renamed from: e  reason: collision with root package name */
        public int f15450e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f15451f;

        /* renamed from: g  reason: collision with root package name */
        public long f15452g;

        /* renamed from: h  reason: collision with root package name */
        public String f15453h;

        /* renamed from: i  reason: collision with root package name */
        public String f15454i;
        public String j;
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
            this.f15447b = true;
            this.f15448c = new b.a.r.h.c.a.e();
            this.f15451f = new ArrayList<>();
        }

        public final JSONObject b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("form_id", this.f15449d);
                    jSONObject.put("lst_fe_ts", this.f15446a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f15448c.d());
                    jSONObject.put("init_res", this.f15450e);
                    jSONObject.put("acquire_ts_cost", this.f15452g);
                    jSONObject.put("oid", this.f15453h);
                    jSONObject.put("sdk_version", this.f15454i);
                    int size = this.f15451f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f15451f.get((size - min) + i2));
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
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f15450e == i2) {
                return;
            }
            this.f15450e = i2;
            this.f15447b = true;
        }

        public void d(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f15448c.c(j, j2)) {
                this.f15447b = true;
            }
        }

        public void e(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || this.f15451f.contains(str)) {
                return;
            }
            this.f15451f.add(str);
            this.f15447b = true;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15449d : (String) invokeV.objValue;
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || this.f15452g == j) {
                return;
            }
            this.f15452g = j;
            this.f15447b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f15449d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15449d = str;
                this.f15447b = true;
            }
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f15446a : invokeV.longValue;
        }

        public void j(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) || this.f15446a == j) {
                return;
            }
            this.f15446a = j;
            this.f15447b = true;
        }

        public void k(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048585, this, str) == null) || this.j == str) {
                return;
            }
            if (str == null || !str.equals(this.f15453h)) {
                this.j = str;
                this.f15447b = true;
            }
        }

        public String l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f15454i : (String) invokeV.objValue;
        }

        public void m(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.equals(this.f15454i, str)) {
                return;
            }
            this.f15454i = str;
            this.f15447b = true;
        }

        public String n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f15453h : (String) invokeV.objValue;
        }

        public void o(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || (str2 = this.f15453h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15453h = str;
                this.f15447b = true;
            }
        }

        public boolean p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                if (this.f15447b) {
                    try {
                        this.k.f15415d.i("cache.dat", b().toString(), true);
                        this.f15447b = false;
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
                String g2 = this.k.f15415d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f15449d = jSONObject.optString("form_id");
                        this.f15446a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f15448c.b(jSONObject.getLong("flags"));
                        this.f15450e = jSONObject.optInt("init_res");
                        this.f15452g = jSONObject.optLong("acquire_ts_cost");
                        this.f15453h = jSONObject.optString("oid");
                        this.f15454i = jSONObject.optString("sdk_version");
                        this.f15451f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f15451f.clear();
                                    return false;
                                }
                                this.f15451f.add(string);
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

    /* loaded from: classes4.dex */
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
        this.f15416e = new g(this);
        this.f15418g = new ArrayList();
        this.f15419h = false;
        this.f15420i = false;
    }

    @Override // b.a.r.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15416e.f() : (String) invokeV.objValue;
    }

    @Override // b.a.r.j.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f15415d = this.f15382a.f(e());
            Context context = this.f15383b.f15385a;
            f fVar = new f(this);
            this.f15417f = fVar;
            this.f15416e.q();
            long currentTimeMillis = System.currentTimeMillis();
            if (!bVar.f15390a && !r(currentTimeMillis)) {
                fVar.f15445c.set(true);
                return;
            }
            this.f15416e.j(currentTimeMillis);
            this.f15416e.d(4L, 124L);
            this.f15416e.g(0L);
            this.f15416e.m("1.0.26");
            this.f15416e.p();
            this.f15383b.f15389e.submit(new b(this, new HandlerC0778a(this, Looper.getMainLooper(), fVar), context, fVar));
        }
    }

    @Override // b.a.r.j.a
    public void g(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f15383b.f15388d.submit(new e(this, cVar));
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
            for (a.c<String> cVar : this.f15418g) {
                l(cVar);
            }
            this.f15418g.clear();
        }
    }

    public final void l(a.c<String> cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f15416e.f())) {
                cVar.a(this.f15416e.f15450e, null, bundle);
            } else {
                cVar.onResult(this.f15416e.f(), bundle);
            }
        }
    }

    public final void m(f fVar, Handler handler, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048582, this, fVar, handler, i2, i3) == null) {
            fVar.f15443a = this.f15383b.f15388d.submit(new d(this, i2, fVar, handler, i3));
        }
    }

    public final void n(f fVar, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{fVar, str, Long.valueOf(j)}) == null) {
            fVar.f15444b = this.f15383b.f15388d.submit(new c(this, j, str, fVar));
        }
    }

    public final boolean r(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j)) == null) ? Math.abs(j - this.f15416e.i()) > 604800000 || (!TextUtils.equals(this.f15416e.l(), "1.0.26") && TextUtils.isEmpty(this.f15416e.n())) : invokeJ.booleanValue;
    }
}
