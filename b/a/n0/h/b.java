package b.a.n0.h;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import b.a.n0.f.e;
import b.a.n0.l.g;
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
public class b extends b.a.n0.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f3653g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public e f3654c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.n0.h.c f3655d;

    /* renamed from: e  reason: collision with root package name */
    public Context f3656e;

    /* renamed from: f  reason: collision with root package name */
    public int f3657f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f3658e;

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
            this.f3658e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f3658e.i(true);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* renamed from: b.a.n0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0102b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f3659e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f3660f;

        public RunnableC0102b(b bVar, long j) {
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
            this.f3660f = bVar;
            this.f3659e = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f3660f.i(false)) {
                        b.a.n0.b.a.h(this.f3660f.f3656e).G(this.f3659e);
                    }
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f3661e;

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
            this.f3661e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b.c(this.f3661e.f3656e).i(true);
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
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
        this.f3657f = 0;
        this.f3656e = context;
        this.f3654c = e.a(context);
        this.f3655d = new b.a.n0.h.c();
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f3653g == null) {
                synchronized (b.class) {
                    if (f3653g == null) {
                        f3653g = new b(context, null);
                    }
                }
            }
            return f3653g;
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
                b.a.n0.l.c.d(th);
            }
            return jSONArray;
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long c0 = b.a.n0.b.a.h(this.f3656e).c0();
            long j0 = b.a.n0.b.a.h(this.f3656e).j0() * b.a.n0.l.c.f3711e;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c0 >= j0 && b.a.n0.l.c.k(this.f3656e) != 0 && b.a.n0.l.c.o(this.f3656e)) {
                b.a.n0.h.a.a().post(new RunnableC0102b(this, currentTimeMillis));
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public synchronized void f(String str, String str2, int i2) {
        b.a.n0.j.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i2) == null) {
            synchronized (this) {
                try {
                    a2 = this.f3655d.a(this.f3656e, str, str2, i2, 1);
                } finally {
                }
                if (a2 == null) {
                    return;
                }
                this.f3657f++;
                b.a.n0.i.a.a(this.f3656e).c(a2);
                if (this.f3657f >= 2 && b.a.n0.l.c.o(this.f3656e)) {
                    this.f3657f = 0;
                    b.a.n0.h.a.a().post(new a(this));
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
                byte[] bytes = g.b(b.a.n0.l.d.f(this.f3656e)).getBytes();
                byte[] f2 = b.a.n0.l.c.f();
                String b2 = this.f3654c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(b.a.n0.l.e.h(f2, bytes), 0)));
                byte[] e2 = this.f3654c.e(f2, str);
                if (e2 == null) {
                    return false;
                }
                String a2 = a(b2, e2);
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                try {
                } catch (Throwable th) {
                    b.a.n0.l.c.d(th);
                }
                return new JSONObject(a2).getInt("response") == 1;
            } catch (Throwable th2) {
                b.a.n0.l.c.d(th2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean i(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        ArrayList<b.a.n0.j.a> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            try {
                int k = b.a.n0.l.c.k(this.f3656e);
                if (k != 2) {
                    z2 = k == 1 ? true : true;
                    return false;
                }
                z2 = false;
                String valueOf = z ? String.valueOf(1) : "1,2";
                if (z2) {
                    b2 = b.a.n0.i.a.a(this.f3656e).e(valueOf);
                    String b0 = b.a.n0.b.a.h(this.f3656e).b0();
                    String a2 = b.a.n0.l.c.a();
                    if (!TextUtils.isEmpty(a2) && !a2.equals(b0)) {
                        b.a.n0.b.a.h(this.f3656e).L(a2);
                        b.a.n0.b.a.h(this.f3656e).T(0L);
                    }
                } else {
                    b2 = b.a.n0.i.a.a(this.f3656e).b(valueOf);
                }
                if (b2 != null && b2.size() != 0) {
                    long n0 = b.a.n0.b.a.h(this.f3656e).n0();
                    int size = b2.size();
                    long h0 = b.a.n0.b.a.h(this.f3656e).h0() * 1048576;
                    JSONArray jSONArray = new JSONArray();
                    ArrayList<b.a.n0.j.a> arrayList = new ArrayList<>();
                    for (int i2 = 0; i2 < size; i2++) {
                        b.a.n0.j.a aVar = b2.get(i2);
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
                        b.a.n0.i.a.a(this.f3656e).d(arrayList);
                        if (z2) {
                            b.a.n0.b.a.h(this.f3656e).T(b.a.n0.b.a.h(this.f3656e).n0() + jSONArray.toString().length());
                        }
                    }
                    return h2;
                }
                return false;
            } catch (Throwable th) {
                b.a.n0.l.c.d(th);
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && b.a.n0.l.c.o(this.f3656e)) {
            b.a.n0.h.a.a().post(new c(this));
        }
    }
}
