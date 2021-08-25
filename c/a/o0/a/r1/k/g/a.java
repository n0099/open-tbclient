package c.a.o0.a.r1.k.g;

import android.text.TextUtils;
import c.a.o0.a.r1.l.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a implements c.a.o0.a.f1.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final int f8358f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public long f8359b;

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, JSONObject> f8360c;

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentHashMap<String, Integer> f8361d;

    /* renamed from: e  reason: collision with root package name */
    public c.a.o0.a.r1.r.c.a f8362e;

    /* renamed from: c.a.o0.a.r1.k.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0356a implements c.a.o0.a.r1.r.c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f8363b;

        public C0356a(a aVar) {
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
            this.f8363b = aVar;
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f8363b.g();
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void c(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                this.f8363b.g();
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public void d(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
                this.f8363b.f8359b = System.currentTimeMillis();
            }
        }

        @Override // c.a.o0.a.r1.r.c.a
        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "LaunchApiCache" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f8364a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1652198114, "Lc/a/o0/a/r1/k/g/a$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1652198114, "Lc/a/o0/a/r1/k/g/a$b;");
                    return;
                }
            }
            f8364a = new a(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2022859488, "Lc/a/o0/a/r1/k/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2022859488, "Lc/a/o0/a/r1/k/g/a;");
                return;
            }
        }
        f8358f = e.c();
    }

    public /* synthetic */ a(C0356a c0356a) {
        this();
    }

    public static a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? b.f8364a : (a) invokeV.objValue;
    }

    public JSONObject d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && e()) {
                JSONObject jSONObject = this.f8360c.get(str);
                if (c.a.o0.a.f1.f.a.f5674a && jSONObject != null) {
                    Integer num = this.f8361d.get(str);
                    if (num == null) {
                        num = 0;
                    }
                    this.f8361d.put(str, Integer.valueOf(num.intValue() + 1));
                }
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? f8358f > 0 && this.f8359b != -1 && System.currentTimeMillis() - this.f8359b <= ((long) f8358f) : invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f8358f <= 0) {
                if (c.a.o0.a.f1.f.a.f5674a) {
                    String str = "cache api close, can't register. duration = " + f8358f;
                    return;
                }
                return;
            }
            c.a.o0.a.r1.r.a.f().h(this.f8362e, f8358f);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f8359b = -1L;
            if (c.a.o0.a.f1.f.a.f5674a) {
                StringBuilder sb = new StringBuilder();
                sb.append("adopt cache api = [ ");
                for (Map.Entry<String, Integer> entry : this.f8361d.entrySet()) {
                    sb.append((Object) entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append(" ");
                }
                sb.append(PreferencesUtil.RIGHT_MOUNT);
                sb.toString();
            }
            this.f8361d.clear();
            this.f8360c.clear();
        }
    }

    public void h(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, str, jSONObject) == null) && !TextUtils.isEmpty(str) && e()) {
            this.f8360c.put(str, jSONObject);
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8359b = -1L;
        this.f8360c = new ConcurrentHashMap<>(10);
        this.f8361d = new ConcurrentHashMap<>(10);
        this.f8362e = new C0356a(this);
    }
}
