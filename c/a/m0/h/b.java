package c.a.m0.h;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import c.a.m0.f.e;
import c.a.m0.l.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends c.a.m0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f4221g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public e f4222c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.m0.h.c f4223d;

    /* renamed from: e  reason: collision with root package name */
    public Context f4224e;

    /* renamed from: f  reason: collision with root package name */
    public int f4225f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f4226e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4226e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f4226e.i(true);
                } catch (Throwable th) {
                    c.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: c.a.m0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0106b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f4227e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f4228f;

        public RunnableC0106b(b bVar, long j2) {
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
            this.f4228f = bVar;
            this.f4227e = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f4228f.i(false)) {
                        c.a.m0.b.a.h(this.f4228f.f4224e).G(this.f4227e);
                    }
                } catch (Throwable th) {
                    c.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f4229e;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4229e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b.c(this.f4229e.f4224e).i(true);
                } catch (Throwable th) {
                    c.a.m0.l.c.d(th);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, Handler handler) {
        super(context, handler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Handler) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f4225f = 0;
        this.f4224e = context;
        this.f4222c = e.a(context);
        this.f4223d = new c.a.m0.h.c();
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f4221g == null) {
                synchronized (b.class) {
                    if (f4221g == null) {
                        f4221g = new b(context, null);
                    }
                }
            }
            return f4221g;
        }
        return (b) invokeL.objValue;
    }

    public final JSONArray d(JSONArray jSONArray, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONArray, str)) == null) {
            try {
                jSONArray.put(new JSONObject(str));
            } catch (Throwable th) {
                c.a.m0.l.c.d(th);
            }
            return jSONArray;
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long c0 = c.a.m0.b.a.h(this.f4224e).c0();
            long j0 = c.a.m0.b.a.h(this.f4224e).j0() * c.a.m0.l.c.f4283e;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c0 >= j0 && c.a.m0.l.c.k(this.f4224e) != 0 && c.a.m0.l.c.o(this.f4224e)) {
                c.a.m0.h.a.a().post(new RunnableC0106b(this, currentTimeMillis));
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public synchronized void f(String str, String str2, int i2) {
        c.a.m0.j.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i2) == null) {
            synchronized (this) {
                try {
                    a2 = this.f4223d.a(this.f4224e, str, str2, i2, 1);
                } finally {
                }
                if (a2 == null) {
                    return;
                }
                this.f4225f++;
                c.a.m0.i.a.a(this.f4224e).c(a2);
                if (this.f4225f >= 2 && c.a.m0.l.c.o(this.f4224e)) {
                    this.f4225f = 0;
                    c.a.m0.h.a.a().post(new a(this));
                }
            }
        }
    }

    public final boolean h(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                byte[] bytes = g.b(c.a.m0.l.d.f(this.f4224e)).getBytes();
                byte[] f2 = c.a.m0.l.c.f();
                String b2 = this.f4222c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(c.a.m0.l.e.h(f2, bytes), 0)));
                byte[] e2 = this.f4222c.e(f2, str);
                if (e2 == null) {
                    return false;
                }
                String a2 = a(b2, e2);
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                try {
                } catch (Throwable th) {
                    c.a.m0.l.c.d(th);
                }
                return new JSONObject(a2).getInt("response") == 1;
            } catch (Throwable th2) {
                c.a.m0.l.c.d(th2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean i(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        ArrayList<c.a.m0.j.a> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            try {
                int k = c.a.m0.l.c.k(this.f4224e);
                if (k != 2) {
                    z2 = k == 1 ? true : true;
                    return false;
                }
                z2 = false;
                String valueOf = z ? String.valueOf(1) : "1,2";
                if (z2) {
                    b2 = c.a.m0.i.a.a(this.f4224e).e(valueOf);
                    String b0 = c.a.m0.b.a.h(this.f4224e).b0();
                    String a2 = c.a.m0.l.c.a();
                    if (!TextUtils.isEmpty(a2) && !a2.equals(b0)) {
                        c.a.m0.b.a.h(this.f4224e).L(a2);
                        c.a.m0.b.a.h(this.f4224e).T(0L);
                    }
                } else {
                    b2 = c.a.m0.i.a.a(this.f4224e).b(valueOf);
                }
                if (b2 != null && b2.size() != 0) {
                    long n0 = c.a.m0.b.a.h(this.f4224e).n0();
                    int size = b2.size();
                    long h0 = c.a.m0.b.a.h(this.f4224e).h0() * 1048576;
                    JSONArray jSONArray = new JSONArray();
                    ArrayList<c.a.m0.j.a> arrayList = new ArrayList<>();
                    for (int i2 = 0; i2 < size; i2++) {
                        c.a.m0.j.a aVar = b2.get(i2);
                        if (aVar != null) {
                            String d2 = aVar.d();
                            if (z2) {
                                if (d2.length() + n0 > h0) {
                                    break;
                                }
                                n0 += d2.length();
                            }
                            d(jSONArray, d2);
                            arrayList.add(aVar);
                        }
                    }
                    if (jSONArray.length() == 0) {
                        return false;
                    }
                    boolean h2 = h(jSONArray.toString());
                    if (h2) {
                        c.a.m0.i.a.a(this.f4224e).d(arrayList);
                        if (z2) {
                            c.a.m0.b.a.h(this.f4224e).T(c.a.m0.b.a.h(this.f4224e).n0() + jSONArray.toString().length());
                        }
                    }
                    return h2;
                }
                return false;
            } catch (Throwable th) {
                c.a.m0.l.c.d(th);
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && c.a.m0.l.c.o(this.f4224e)) {
            c.a.m0.h.a.a().post(new c(this));
        }
    }
}
