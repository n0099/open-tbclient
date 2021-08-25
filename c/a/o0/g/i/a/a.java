package c.a.o0.g.i.a;

import c.a.o0.a.a2.e;
import c.a.o0.a.f2.a;
import c.a.o0.a.k;
import c.a.o0.a.u0.b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c.a.o0.g.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f10916c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c.a.o0.g.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0548a implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f10917a;

        public C0548a(a aVar, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10917a = bVar;
        }

        @Override // c.a.o0.a.f2.a.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == -1) {
                    a.c(this.f10917a, "202");
                } else if (i2 != 1) {
                    this.f10917a.onFail(101, "noPermission");
                } else {
                    a.c(this.f10917a, "200");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-982527362, "Lc/a/o0/g/i/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-982527362, "Lc/a/o0/g/i/a/a;");
                return;
            }
        }
        f10916c = k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("addShortcutToDesktop");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void c(b bVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, bVar, str) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", str);
            } catch (JSONException e2) {
                if (f10916c) {
                    e2.printStackTrace();
                }
            }
            bVar.a(jSONObject);
        }
    }

    @Override // c.a.o0.g.f.a
    public c.a.o0.a.u.h.b a(JSONObject jSONObject, b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            e Q = e.Q();
            if (Q != null && Q.x() != null && Q.L() != null) {
                if (c.a.o0.a.f2.a.s(Q.x(), Q.L().K(), Q.L().H()) == 1) {
                    c(bVar, "201");
                    return null;
                }
                c.a.o0.a.f2.a.j(Q.x(), Q.L(), 1, new C0548a(this, bVar));
                return null;
            }
            bVar.onFail(100, "swan or activity is null");
            boolean z = f10916c;
            return null;
        }
        return (c.a.o0.a.u.h.b) invokeLL.objValue;
    }
}
