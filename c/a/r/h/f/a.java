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
    public a.C0735a f15487d;

    /* renamed from: e  reason: collision with root package name */
    public e f15488e;

    /* renamed from: f  reason: collision with root package name */
    public d f15489f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f15490g;

    /* renamed from: c.a.r.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0739a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15491a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f15492b;

        /* renamed from: c.a.r.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0740a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC0739a f15493e;

            public RunnableC0740a(HandlerC0739a handlerC0739a) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {handlerC0739a};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f15493e = handlerC0739a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15493e.f15491a.f15512c.get()) {
                    return;
                }
                this.f15493e.f15492b.f15488e.d(64L, 124L);
                this.f15493e.f15492b.f15488e.m();
                this.f15493e.f15492b.i();
                this.f15493e.f15491a.f15512c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0739a(a aVar, Looper looper, d dVar) {
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
            this.f15492b = aVar;
            this.f15491a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f15492b.f15455b.f15462d.submit(new RunnableC0740a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f15494e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f15495f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f15496g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f15497h;

        /* renamed from: c.a.r.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0741a extends f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f15498a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f15499b;

            /* renamed from: c.a.r.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0742a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f15500e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f15501f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f15502g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ C0741a f15503h;

                public RunnableC0742a(C0741a c0741a, long j2, boolean z, String str) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0741a, Long.valueOf(j2), Boolean.valueOf(z), str};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f15503h = c0741a;
                    this.f15500e = j2;
                    this.f15501f = z;
                    this.f15502g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f15503h.f15499b.f15497h.f15488e.i(this.f15500e - this.f15503h.f15498a);
                        this.f15503h.f15499b.f15497h.f15488e.d(this.f15501f ? 1L : 2L, 3L);
                        this.f15503h.f15499b.f15497h.f15488e.d(16L, 124L);
                        this.f15503h.f15499b.f15497h.f15488e.h(this.f15502g);
                        if (!TextUtils.isEmpty(this.f15502g)) {
                            try {
                                String b2 = c.a.r.h.a.b("A10", new c.a.r.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f15502g.getBytes("UTF-8")));
                                this.f15503h.f15499b.f15497h.f15488e.e(b2);
                                this.f15503h.f15499b.f15497h.f15488e.l(b2);
                                this.f15503h.f15499b.f15497h.f15488e.d(32L, 124L);
                            } catch (Exception unused) {
                            }
                        }
                        this.f15503h.f15499b.f15497h.f15488e.m();
                        if (this.f15503h.f15499b.f15496g.f15512c.get()) {
                            return;
                        }
                        this.f15503h.f15499b.f15497h.i();
                        this.f15503h.f15499b.f15496g.f15512c.set(true);
                    }
                }
            }

            public C0741a(b bVar, long j2) {
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
                this.f15499b = bVar;
                this.f15498a = j2;
            }

            @Override // c.a.r.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, idSupplier) == null) {
                    String oaid = idSupplier.getOAID();
                    this.f15499b.f15494e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f15499b;
                    bVar.f15496g.f15511b = bVar.f15497h.f15455b.f15462d.submit(new RunnableC0742a(this, elapsedRealtime, z, oaid));
                }
            }
        }

        /* renamed from: c.a.r.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0743b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f15504e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f15505f;

            public RunnableC0743b(b bVar, int i2) {
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
                this.f15505f = bVar;
                this.f15504e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = this.f15504e;
                    if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                        if (!this.f15505f.f15496g.f15512c.get()) {
                            this.f15505f.f15496g.f15512c.set(true);
                            this.f15505f.f15497h.i();
                        }
                        this.f15505f.f15494e.removeMessages(0);
                    }
                    this.f15505f.f15497h.f15488e.c(this.f15504e);
                    this.f15505f.f15497h.f15488e.d(8L, 124L);
                    this.f15505f.f15497h.f15488e.m();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f15506e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f15507f;

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
                this.f15507f = bVar;
                this.f15506e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f15507f.f15494e.removeMessages(0);
                    this.f15507f.f15497h.f15488e.j(Log.getStackTraceString(this.f15506e));
                    this.f15507f.f15497h.f15488e.m();
                    if (this.f15507f.f15496g.f15512c.get()) {
                        return;
                    }
                    this.f15507f.f15496g.f15512c.set(true);
                    this.f15507f.f15497h.i();
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
            this.f15497h = aVar;
            this.f15494e = handler;
            this.f15495f = context;
            this.f15496g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15494e.sendEmptyMessageDelayed(0, 50000L);
                try {
                    int InitSdk = new MdidSdk().InitSdk(this.f15495f, new C0741a(this, SystemClock.elapsedRealtime()));
                    this.f15496g.f15510a = this.f15497h.f15455b.f15462d.submit(new RunnableC0743b(this, InitSdk));
                } catch (Throwable th) {
                    this.f15497h.f15455b.f15462d.submit(new c(this, th));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f15508e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15509f;

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
            this.f15509f = aVar;
            this.f15508e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f15509f.f15489f.f15512c.get()) {
                    this.f15509f.j(this.f15508e);
                } else {
                    this.f15509f.f15490g.add(this.f15508e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f15510a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f15511b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f15512c;

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
            this.f15512c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15513a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15514b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.r.g.c.a.e f15515c;

        /* renamed from: d  reason: collision with root package name */
        public String f15516d;

        /* renamed from: e  reason: collision with root package name */
        public int f15517e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f15518f;

        /* renamed from: g  reason: collision with root package name */
        public long f15519g;

        /* renamed from: h  reason: collision with root package name */
        public String f15520h;

        /* renamed from: i  reason: collision with root package name */
        public String f15521i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f15522j;

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
            this.f15522j = aVar;
            this.f15514b = true;
            this.f15515c = new c.a.r.g.c.a.e();
            this.f15518f = new ArrayList<>();
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15516d : (String) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f15517e == i2) {
                return;
            }
            this.f15517e = i2;
            this.f15514b = true;
        }

        public void d(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f15515c.c(j2, j3)) {
                this.f15514b = true;
            }
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f15516d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15516d = str;
                this.f15514b = true;
            }
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15513a : invokeV.longValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.f15513a == j2) {
                return;
            }
            this.f15513a = j2;
            this.f15514b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f15520h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15520h = str;
                this.f15514b = true;
            }
        }

        public void i(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) || this.f15519g == j2) {
                return;
            }
            this.f15519g = j2;
            this.f15514b = true;
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || this.f15521i == str) {
                return;
            }
            if (str == null || !str.equals(this.f15520h)) {
                this.f15521i = str;
                this.f15514b = true;
            }
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String g2 = this.f15522j.f15487d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f15516d = jSONObject.optString("form_id");
                        this.f15513a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f15515c.b(jSONObject.getLong("flags"));
                        this.f15517e = jSONObject.optInt("init_res");
                        this.f15519g = jSONObject.optLong("acquire_ts_cost");
                        this.f15520h = jSONObject.optString("oid");
                        this.f15518f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f15518f.clear();
                                    return false;
                                }
                                this.f15518f.add(string);
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
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f15518f.contains(str)) {
                return;
            }
            this.f15518f.add(str);
            this.f15514b = true;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f15514b) {
                    try {
                        this.f15522j.f15487d.i("cache.dat", n().toString(), true);
                        this.f15514b = false;
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
                    jSONObject.put("form_id", this.f15516d);
                    jSONObject.put("lst_fe_ts", this.f15513a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f15515c.d());
                    jSONObject.put("init_res", this.f15517e);
                    jSONObject.put("acquire_ts_cost", this.f15519g);
                    jSONObject.put("oid", this.f15520h);
                    int size = this.f15518f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f15518f.get((size - min) + i2));
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
        this.f15488e = new e(this);
        this.f15490g = new ArrayList();
    }

    @Override // c.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15488e.b() : (String) invokeV.objValue;
    }

    @Override // c.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f15487d = this.f15454a.f(e());
            Context context = this.f15455b.f15459a;
            d dVar = new d(this);
            this.f15489f = dVar;
            this.f15488e.k();
            long currentTimeMillis = System.currentTimeMillis();
            if (!cVar.f15464a && Math.abs(currentTimeMillis - this.f15488e.f()) <= 604800000) {
                dVar.f15512c.set(true);
                return;
            }
            this.f15488e.g(currentTimeMillis);
            this.f15488e.d(4L, 124L);
            this.f15488e.i(0L);
            this.f15488e.m();
            this.f15455b.f15463e.submit(new b(this, new HandlerC0739a(this, Looper.getMainLooper(), dVar), context, dVar));
        }
    }

    @Override // c.a.r.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f15455b.f15462d.submit(new c(this, dVar));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f15490g) {
                j(dVar);
            }
            this.f15490g.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f15488e.b())) {
                dVar.a(this.f15488e.f15517e, null, bundle);
            } else {
                dVar.onResult(this.f15488e.b(), bundle);
            }
        }
    }
}
