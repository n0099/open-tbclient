package c.a.l0.i;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import c.a.l0.m.e;
import c.a.l0.m.g;
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
public class b extends c.a.l0.g.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static volatile b f3640g;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public c.a.l0.g.d f3641c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.l0.i.c f3642d;

    /* renamed from: e  reason: collision with root package name */
    public Context f3643e;

    /* renamed from: f  reason: collision with root package name */
    public int f3644f;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.a.i(true);
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
        }
    }

    /* renamed from: c.a.l0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0202b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f3645b;

        public RunnableC0202b(b bVar, long j) {
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
            this.f3645b = bVar;
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f3645b.i(false)) {
                        c.a.l0.b.a.f(this.f3645b.f3643e).F(this.a);
                    }
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        public c(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    b.c(this.a.f3643e).i(true);
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Handler) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3644f = 0;
        this.f3643e = context;
        this.f3641c = c.a.l0.g.d.a(context);
        this.f3642d = new c.a.l0.i.c();
    }

    public static b c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f3640g == null) {
                synchronized (b.class) {
                    if (f3640g == null) {
                        f3640g = new b(context, null);
                    }
                }
            }
            return f3640g;
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
                c.a.l0.m.c.d(th);
            }
            return jSONArray;
        }
        return (JSONArray) invokeLL.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long c0 = c.a.l0.b.a.f(this.f3643e).c0();
            long j0 = c.a.l0.b.a.f(this.f3643e).j0() * c.a.l0.m.c.f3697e;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - c0 >= j0 && c.a.l0.m.c.j(this.f3643e) != 0 && c.a.l0.m.c.n(this.f3643e)) {
                c.a.l0.i.a.a().post(new RunnableC0202b(this, currentTimeMillis));
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public synchronized void f(String str, String str2, int i) {
        c.a.l0.k.a a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, str, str2, i) == null) {
            synchronized (this) {
                try {
                    a2 = this.f3642d.a(this.f3643e, str, str2, i, 1);
                } finally {
                }
                if (a2 == null) {
                    return;
                }
                this.f3644f++;
                c.a.l0.j.a.a(this.f3643e).c(a2);
                if (this.f3644f >= 2 && c.a.l0.m.c.n(this.f3643e)) {
                    this.f3644f = 0;
                    c.a.l0.i.a.a().post(new a(this));
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
                byte[] bytes = g.b(c.a.l0.m.d.a(this.f3643e)).getBytes();
                byte[] f2 = c.a.l0.m.c.f();
                String b2 = this.f3641c.b("p/1/r", URLEncoder.encode(Base64.encodeToString(e.h(f2, bytes), 0)));
                byte[] e2 = this.f3641c.e(f2, str);
                if (e2 == null) {
                    return false;
                }
                String a2 = a(b2, e2);
                if (TextUtils.isEmpty(a2)) {
                    return false;
                }
                try {
                } catch (Throwable th) {
                    c.a.l0.m.c.d(th);
                }
                return new JSONObject(a2).getInt("response") == 1;
            } catch (Throwable th2) {
                c.a.l0.m.c.d(th2);
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public final boolean i(boolean z) {
        InterceptResult invokeZ;
        boolean z2;
        ArrayList<c.a.l0.k.a> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            try {
                int j = c.a.l0.m.c.j(this.f3643e);
                if (j != 2) {
                    z2 = j == 1 ? true : true;
                    return false;
                }
                z2 = false;
                String valueOf = z ? String.valueOf(1) : "1,2";
                if (z2) {
                    b2 = c.a.l0.j.a.a(this.f3643e).e(valueOf);
                    String b0 = c.a.l0.b.a.f(this.f3643e).b0();
                    String a2 = c.a.l0.m.c.a();
                    if (!TextUtils.isEmpty(a2) && !a2.equals(b0)) {
                        c.a.l0.b.a.f(this.f3643e).G(a2);
                        c.a.l0.b.a.f(this.f3643e).U(0L);
                    }
                } else {
                    b2 = c.a.l0.j.a.a(this.f3643e).b(valueOf);
                }
                if (b2 != null && b2.size() != 0) {
                    long n0 = c.a.l0.b.a.f(this.f3643e).n0();
                    int size = b2.size();
                    long h0 = c.a.l0.b.a.f(this.f3643e).h0() * 1048576;
                    JSONArray jSONArray = new JSONArray();
                    ArrayList<c.a.l0.k.a> arrayList = new ArrayList<>();
                    for (int i = 0; i < size; i++) {
                        c.a.l0.k.a aVar = b2.get(i);
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
                        c.a.l0.j.a.a(this.f3643e).d(arrayList);
                        if (z2) {
                            c.a.l0.b.a.f(this.f3643e).U(c.a.l0.b.a.f(this.f3643e).n0() + jSONArray.toString().length());
                        }
                    }
                    return h2;
                }
                return false;
            } catch (Throwable th) {
                c.a.l0.m.c.d(th);
                return false;
            }
        }
        return invokeZ.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && c.a.l0.m.c.n(this.f3643e)) {
            c.a.l0.i.a.a().post(new c(this));
        }
    }
}
