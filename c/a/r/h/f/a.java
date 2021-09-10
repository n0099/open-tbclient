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
    public a.C0737a f15478d;

    /* renamed from: e  reason: collision with root package name */
    public e f15479e;

    /* renamed from: f  reason: collision with root package name */
    public d f15480f;

    /* renamed from: g  reason: collision with root package name */
    public List<a.d<String>> f15481g;

    /* renamed from: c.a.r.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class HandlerC0741a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f15482a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f15483b;

        /* renamed from: c.a.r.h.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0742a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ HandlerC0741a f15484e;

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
                this.f15484e = handlerC0741a;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f15484e.f15482a.f15503c.get()) {
                    return;
                }
                this.f15484e.f15483b.f15479e.d(64L, 124L);
                this.f15484e.f15483b.f15479e.m();
                this.f15484e.f15483b.i();
                this.f15484e.f15482a.f15503c.set(true);
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
            this.f15483b = aVar;
            this.f15482a = dVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.f15483b.f15446b.f15453d.submit(new RunnableC0742a(this));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Handler f15485e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Context f15486f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d f15487g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f15488h;

        /* renamed from: c.a.r.h.f.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0743a extends f {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f15489a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f15490b;

            /* renamed from: c.a.r.h.f.a$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0744a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ long f15491e;

                /* renamed from: f  reason: collision with root package name */
                public final /* synthetic */ boolean f15492f;

                /* renamed from: g  reason: collision with root package name */
                public final /* synthetic */ String f15493g;

                /* renamed from: h  reason: collision with root package name */
                public final /* synthetic */ C0743a f15494h;

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
                    this.f15494h = c0743a;
                    this.f15491e = j2;
                    this.f15492f = z;
                    this.f15493g = str;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f15494h.f15490b.f15488h.f15479e.i(this.f15491e - this.f15494h.f15489a);
                        this.f15494h.f15490b.f15488h.f15479e.d(this.f15492f ? 1L : 2L, 3L);
                        this.f15494h.f15490b.f15488h.f15479e.d(16L, 124L);
                        this.f15494h.f15490b.f15488h.f15479e.h(this.f15493g);
                        if (!TextUtils.isEmpty(this.f15493g)) {
                            try {
                                String b2 = c.a.r.h.a.b("A10", new c.a.r.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(this.f15493g.getBytes("UTF-8")));
                                this.f15494h.f15490b.f15488h.f15479e.e(b2);
                                this.f15494h.f15490b.f15488h.f15479e.l(b2);
                                this.f15494h.f15490b.f15488h.f15479e.d(32L, 124L);
                            } catch (Exception unused) {
                            }
                        }
                        this.f15494h.f15490b.f15488h.f15479e.m();
                        if (this.f15494h.f15490b.f15487g.f15503c.get()) {
                            return;
                        }
                        this.f15494h.f15490b.f15488h.i();
                        this.f15494h.f15490b.f15487g.f15503c.set(true);
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
                this.f15490b = bVar;
                this.f15489a = j2;
            }

            @Override // c.a.r.h.f.a.f
            public void a(boolean z, IdSupplier idSupplier) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, idSupplier) == null) {
                    String oaid = idSupplier.getOAID();
                    this.f15490b.f15485e.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar = this.f15490b;
                    bVar.f15487g.f15502b = bVar.f15488h.f15446b.f15453d.submit(new RunnableC0744a(this, elapsedRealtime, z, oaid));
                }
            }
        }

        /* renamed from: c.a.r.h.f.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0745b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ int f15495e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f15496f;

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
                this.f15496f = bVar;
                this.f15495e = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int i2 = this.f15495e;
                    if (i2 == 1008612 || i2 == 1008611 || i2 == 1008615) {
                        if (!this.f15496f.f15487g.f15503c.get()) {
                            this.f15496f.f15487g.f15503c.set(true);
                            this.f15496f.f15488h.i();
                        }
                        this.f15496f.f15485e.removeMessages(0);
                    }
                    this.f15496f.f15488h.f15479e.c(this.f15495e);
                    this.f15496f.f15488h.f15479e.d(8L, 124L);
                    this.f15496f.f15488h.f15479e.m();
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Throwable f15497e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ b f15498f;

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
                this.f15498f = bVar;
                this.f15497e = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f15498f.f15485e.removeMessages(0);
                    this.f15498f.f15488h.f15479e.j(Log.getStackTraceString(this.f15497e));
                    this.f15498f.f15488h.f15479e.m();
                    if (this.f15498f.f15487g.f15503c.get()) {
                        return;
                    }
                    this.f15498f.f15487g.f15503c.set(true);
                    this.f15498f.f15488h.i();
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
            this.f15488h = aVar;
            this.f15485e = handler;
            this.f15486f = context;
            this.f15487g = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f15485e.sendEmptyMessageDelayed(0, 50000L);
                try {
                    int InitSdk = new MdidSdk().InitSdk(this.f15486f, new C0743a(this, SystemClock.elapsedRealtime()));
                    this.f15487g.f15501a = this.f15488h.f15446b.f15453d.submit(new RunnableC0745b(this, InitSdk));
                } catch (Throwable th) {
                    this.f15488h.f15446b.f15453d.submit(new c(this, th));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a.d f15499e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15500f;

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
            this.f15500f = aVar;
            this.f15499e = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f15500f.f15480f.f15503c.get()) {
                    this.f15500f.j(this.f15499e);
                } else {
                    this.f15500f.f15481g.add(this.f15499e);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Future<?> f15501a;

        /* renamed from: b  reason: collision with root package name */
        public Future<?> f15502b;

        /* renamed from: c  reason: collision with root package name */
        public AtomicBoolean f15503c;

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
            this.f15503c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes3.dex */
    public class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15504a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15505b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.r.g.c.a.e f15506c;

        /* renamed from: d  reason: collision with root package name */
        public String f15507d;

        /* renamed from: e  reason: collision with root package name */
        public int f15508e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<String> f15509f;

        /* renamed from: g  reason: collision with root package name */
        public long f15510g;

        /* renamed from: h  reason: collision with root package name */
        public String f15511h;

        /* renamed from: i  reason: collision with root package name */
        public String f15512i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f15513j;

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
            this.f15513j = aVar;
            this.f15505b = true;
            this.f15506c = new c.a.r.g.c.a.e();
            this.f15509f = new ArrayList<>();
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15507d : (String) invokeV.objValue;
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.f15508e == i2) {
                return;
            }
            this.f15508e = i2;
            this.f15505b = true;
        }

        public void d(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f15506c.c(j2, j3)) {
                this.f15505b = true;
            }
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f15507d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15507d = str;
                this.f15505b = true;
            }
        }

        public long f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f15504a : invokeV.longValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) || this.f15504a == j2) {
                return;
            }
            this.f15504a = j2;
            this.f15505b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.f15511h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15511h = str;
                this.f15505b = true;
            }
        }

        public void i(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048583, this, j2) == null) || this.f15510g == j2) {
                return;
            }
            this.f15510g = j2;
            this.f15505b = true;
        }

        public void j(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) || this.f15512i == str) {
                return;
            }
            if (str == null || !str.equals(this.f15511h)) {
                this.f15512i = str;
                this.f15505b = true;
            }
        }

        public boolean k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                String g2 = this.f15513j.f15478d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f15507d = jSONObject.optString("form_id");
                        this.f15504a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.f15506c.b(jSONObject.getLong("flags"));
                        this.f15508e = jSONObject.optInt("init_res");
                        this.f15510g = jSONObject.optLong("acquire_ts_cost");
                        this.f15511h = jSONObject.optString("oid");
                        this.f15509f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i2 = optJSONObject.getInt("count");
                            for (int i3 = 0; i3 < i2; i3++) {
                                String string = optJSONObject.getString("id_" + i3);
                                if (TextUtils.isEmpty(string)) {
                                    this.f15509f.clear();
                                    return false;
                                }
                                this.f15509f.add(string);
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
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f15509f.contains(str)) {
                return;
            }
            this.f15509f.add(str);
            this.f15505b = true;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                if (this.f15505b) {
                    try {
                        this.f15513j.f15478d.i("cache.dat", n().toString(), true);
                        this.f15505b = false;
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
                    jSONObject.put("form_id", this.f15507d);
                    jSONObject.put("lst_fe_ts", this.f15504a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.f15506c.d());
                    jSONObject.put("init_res", this.f15508e);
                    jSONObject.put("acquire_ts_cost", this.f15510g);
                    jSONObject.put("oid", this.f15511h);
                    int size = this.f15509f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i2 = 0; i2 < min; i2++) {
                            jSONObject2.put("id_" + i2, this.f15509f.get((size - min) + i2));
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
        this.f15479e = new e(this);
        this.f15481g = new ArrayList();
    }

    @Override // c.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15479e.b() : (String) invokeV.objValue;
    }

    @Override // c.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f15478d = this.f15445a.f(e());
            Context context = this.f15446b.f15450a;
            d dVar = new d(this);
            this.f15480f = dVar;
            this.f15479e.k();
            long currentTimeMillis = System.currentTimeMillis();
            if (!cVar.f15455a && Math.abs(currentTimeMillis - this.f15479e.f()) <= 604800000) {
                dVar.f15503c.set(true);
                return;
            }
            this.f15479e.g(currentTimeMillis);
            this.f15479e.d(4L, 124L);
            this.f15479e.i(0L);
            this.f15479e.m();
            this.f15446b.f15454e.submit(new b(this, new HandlerC0741a(this, Looper.getMainLooper(), dVar), context, dVar));
        }
    }

    @Override // c.a.r.h.a
    public void g(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.f15446b.f15453d.submit(new c(this, dVar));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (a.d<String> dVar : this.f15481g) {
                j(dVar);
            }
            this.f15481g.clear();
        }
    }

    public final void j(a.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.f15479e.b())) {
                dVar.a(this.f15479e.f15508e, null, bundle);
            } else {
                dVar.onResult(this.f15479e.b(), bundle);
            }
        }
    }
}
