package c.a.r.h.e;

import android.text.TextUtils;
import c.a.r.g.c.a.b;
import c.a.r.g.c.a.e;
import c.a.r.g.d.a;
import c.a.r.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends c.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1379a f29640d;

    /* renamed from: e  reason: collision with root package name */
    public C1382a f29641e;

    /* renamed from: c.a.r.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1382a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f29642a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f29643b;

        /* renamed from: c  reason: collision with root package name */
        public e f29644c;

        /* renamed from: d  reason: collision with root package name */
        public String f29645d;

        /* renamed from: e  reason: collision with root package name */
        public String f29646e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f29647f;

        public C1382a(a aVar) {
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
            this.f29647f = aVar;
            this.f29643b = true;
            this.f29644c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29645d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f29645d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f29645d = str;
                this.f29643b = true;
            }
        }

        public void c(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) || this.f29642a == j2) {
                return;
            }
            this.f29642a = j2;
            this.f29643b = true;
        }

        public void d(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f29646e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f29646e = str;
                this.f29643b = true;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                String g2 = this.f29647f.f29640d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f29645d = jSONObject.optString("form_id");
                    this.f29642a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f29646e = jSONObject.getString("uuid");
                    this.f29644c.b(jSONObject.getLong("flags"));
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f29643b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f29645d);
                        jSONObject.put("lst_fe_ts", this.f29642a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f29644c.d());
                        jSONObject.put("uuid", this.f29646e);
                        this.f29647f.f29640d.i("cache.dat", jSONObject.toString(), true);
                        this.f29643b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a() {
        super("iid");
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
        this.f29641e = new C1382a(this);
    }

    @Override // c.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29641e.a() : (String) invokeV.objValue;
    }

    @Override // c.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f29640d = this.f29615a.f(e());
            this.f29641e.e();
            if (TextUtils.isEmpty(this.f29641e.a())) {
                String uuid = UUID.randomUUID().toString();
                this.f29641e.d(uuid);
                try {
                    this.f29641e.b(c.a.r.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f29641e.c(System.currentTimeMillis());
            }
            this.f29641e.f();
        }
    }
}
