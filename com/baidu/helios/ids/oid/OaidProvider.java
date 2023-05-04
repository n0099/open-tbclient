package com.baidu.helios.ids.oid;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.e50;
import com.baidu.tieba.k40;
import com.baidu.tieba.n40;
import com.baidu.tieba.q40;
import com.baidu.tieba.t40;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class OaidProvider extends t40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public q40.a d;
    public h e;
    public g f;
    public List<t40.d<String>> g;

    /* loaded from: classes2.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g a;
        public final /* synthetic */ OaidProvider b;

        /* renamed from: com.baidu.helios.ids.oid.OaidProvider$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0096a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0096a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.c.get()) {
                    return;
                }
                this.a.b.e.d(64L, 124L);
                this.a.b.e.o();
                this.a.b.i();
                this.a.a.c.set(true);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OaidProvider oaidProvider, Looper looper, g gVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oaidProvider, looper, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oaidProvider;
            this.a = gVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 0) {
                this.b.b.d.submit(new RunnableC0096a(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Handler a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ g c;
        public final /* synthetic */ OaidProvider d;

        /* loaded from: classes2.dex */
        public class a implements e50.a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ b b;

            public a(b bVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = bVar;
                this.a = j;
            }

            @Override // com.baidu.tieba.e50.a
            public void a(boolean z, String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeZL(1048576, this, z, str) == null) {
                    if (!z || TextUtils.isEmpty(str)) {
                        b bVar = this.b;
                        bVar.d.k(bVar.c, bVar.a, 1008612, 0);
                        return;
                    }
                    this.b.a.removeMessages(0);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    b bVar2 = this.b;
                    bVar2.d.l(bVar2.c, str, elapsedRealtime - this.a);
                }
            }
        }

        public b(OaidProvider oaidProvider, Handler handler, Context context, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oaidProvider, handler, context, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = oaidProvider;
            this.a = handler;
            this.b = context;
            this.c = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.sendEmptyMessageDelayed(0, 50000L);
                e50.a().b(this.b, new a(this, SystemClock.elapsedRealtime()));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ String b;
        public final /* synthetic */ g c;
        public final /* synthetic */ OaidProvider d;

        public c(OaidProvider oaidProvider, long j, String str, g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oaidProvider, Long.valueOf(j), str, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = oaidProvider;
            this.a = j;
            this.b = str;
            this.c = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.e.j(this.a);
                this.d.e.d(16L, 124L);
                this.d.e.h(this.b);
                if (!TextUtils.isEmpty(this.b) && !TextUtils.equals(this.b, "00000000-0000-0000-0000-000000000000")) {
                    try {
                        String b = t40.b("A10", new k40("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).c(this.b.getBytes("UTF-8")));
                        this.d.e.e(b);
                        this.d.e.l(b);
                        this.d.e.d(32L, 124L);
                    } catch (Exception unused) {
                    }
                }
                this.d.e.o();
                if (this.c.c.get()) {
                    return;
                }
                this.d.i();
                this.c.c.set(true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class d implements IIdentifierListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

    /* loaded from: classes2.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ g b;
        public final /* synthetic */ Handler c;
        public final /* synthetic */ int d;
        public final /* synthetic */ OaidProvider e;

        public e(OaidProvider oaidProvider, int i, g gVar, Handler handler, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oaidProvider, Integer.valueOf(i), gVar, handler, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = oaidProvider;
            this.a = i;
            this.b = gVar;
            this.c = handler;
            this.d = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int i = this.a;
                if (i == 1008612 || i == 1008616 || i == 1008611 || i == 1008615) {
                    if (!this.b.c.get()) {
                        this.b.c.set(true);
                        this.e.i();
                    }
                    this.c.removeMessages(this.d);
                }
                this.e.e.c(this.a);
                this.e.e.d(8L, 124L);
                this.e.e.o();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t40.d a;
        public final /* synthetic */ OaidProvider b;

        public f(OaidProvider oaidProvider, t40.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oaidProvider, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = oaidProvider;
            this.a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.f.c.get()) {
                    this.b.j(this.a);
                } else {
                    this.b.g.add(this.a);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Future<?> a;
        public Future<?> b;
        public AtomicBoolean c;

        public g(OaidProvider oaidProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oaidProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = new AtomicBoolean(false);
        }
    }

    /* loaded from: classes2.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public boolean b;
        public n40 c;
        public String d;
        public int e;
        public ArrayList<String> f;
        public long g;
        public String h;
        public String i;
        public final /* synthetic */ OaidProvider j;

        public h(OaidProvider oaidProvider) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oaidProvider};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = oaidProvider;
            this.b = true;
            this.c = new n40();
            this.f = new ArrayList<>();
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d : (String) invokeV.objValue;
        }

        public void c(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.e == i) {
                return;
            }
            this.e = i;
            this.b = true;
        }

        public void d(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.c.c(j, j2)) {
                this.b = true;
            }
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.d = str;
                this.b = true;
            }
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h : (String) invokeV.objValue;
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048581, this, j) == null) || this.a == j) {
                return;
            }
            this.a = j;
            this.b = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048582, this, str) == null) || (str2 = this.h) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.h = str;
                this.b = true;
            }
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : invokeV.longValue;
        }

        public void j(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) || this.g == j) {
                return;
            }
            this.g = j;
            this.b = true;
        }

        public String k() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.i : (String) invokeV.objValue;
        }

        public void l(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || this.f.contains(str)) {
                return;
            }
            this.f.add(str);
            this.b = true;
        }

        public void m(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || TextUtils.equals(this.i, str)) {
                return;
            }
            this.i = str;
            this.b = true;
        }

        public boolean n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                String g = this.j.d.g("cache.dat", true);
                if (!TextUtils.isEmpty(g)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g);
                        this.d = jSONObject.optString("form_id");
                        this.a = jSONObject.getLong("lst_fe_ts");
                        jSONObject.getInt("c_form_ver");
                        this.c.b(jSONObject.getLong("flags"));
                        this.e = jSONObject.optInt("init_res");
                        this.g = jSONObject.optLong("acquire_ts_cost");
                        this.h = jSONObject.optString("oid");
                        this.i = jSONObject.optString("sdk_version");
                        this.f.clear();
                        JSONObject optJSONObject = jSONObject.optJSONObject("his_form_ids");
                        if (optJSONObject != null) {
                            int i = optJSONObject.getInt("count");
                            for (int i2 = 0; i2 < i; i2++) {
                                String string = optJSONObject.getString("id_" + i2);
                                if (TextUtils.isEmpty(string)) {
                                    this.f.clear();
                                    return false;
                                }
                                this.f.add(string);
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

        public boolean o() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                if (this.b) {
                    try {
                        this.j.d.i("cache.dat", p().toString(), true);
                        this.b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public final JSONObject p() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("form_id", this.d);
                    jSONObject.put("lst_fe_ts", this.a);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.c.d());
                    jSONObject.put("init_res", this.e);
                    jSONObject.put("acquire_ts_cost", this.g);
                    jSONObject.put("oid", this.h);
                    jSONObject.put("sdk_version", this.i);
                    int size = this.f.size();
                    if (size > 0) {
                        int min = Math.min(size, 5);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject.put("his_form_ids", jSONObject2);
                        jSONObject2.put("count", min);
                        for (int i = 0; i < min; i++) {
                            jSONObject2.put("id_" + i, this.f.get((size - min) + i));
                        }
                    }
                } catch (Exception unused) {
                }
                return jSONObject;
            }
            return (JSONObject) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OaidProvider() {
        super("oid");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new h(this);
        this.g = new ArrayList();
    }

    @Override // com.baidu.tieba.t40
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e.b() : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.t40
    public void f(t40.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.d = this.a.f(e());
            Context context = this.b.a;
            g gVar = new g(this);
            this.f = gVar;
            this.e.n();
            long currentTimeMillis = System.currentTimeMillis();
            if (!cVar.a && !p(currentTimeMillis)) {
                gVar.c.set(true);
                return;
            }
            this.e.g(currentTimeMillis);
            this.e.d(4L, 124L);
            this.e.j(0L);
            this.e.m("1.2.0");
            this.e.o();
            this.b.e.submit(new b(this, new a(this, Looper.getMainLooper(), gVar), context, gVar));
        }
    }

    @Override // com.baidu.tieba.t40
    public void g(t40.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, dVar) == null) {
            this.b.d.submit(new f(this, dVar));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            for (t40.d<String> dVar : this.g) {
                j(dVar);
            }
            this.g.clear();
        }
    }

    public final void j(t40.d<String> dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dVar) == null) {
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(this.e.b())) {
                dVar.a(this.e.e, null, bundle);
            } else {
                dVar.onResult(this.e.b(), bundle);
            }
        }
    }

    public final void k(g gVar, Handler handler, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048581, this, gVar, handler, i, i2) == null) {
            gVar.a = this.b.d.submit(new e(this, i, gVar, handler, i2));
        }
    }

    public final void l(g gVar, String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{gVar, str, Long.valueOf(j)}) == null) {
            gVar.b = this.b.d.submit(new c(this, j, str, gVar));
        }
    }

    public final boolean p(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j)) == null) ? Math.abs(j - this.e.i()) > 604800000 || (!TextUtils.equals(this.e.k(), "1.2.0") && TextUtils.isEmpty(this.e.f())) : invokeJ.booleanValue;
    }
}
