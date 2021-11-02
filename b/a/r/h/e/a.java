package b.a.r.h.e;

import android.text.TextUtils;
import b.a.r.g.c.a.b;
import b.a.r.g.c.a.e;
import b.a.r.g.d.a;
import b.a.r.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends b.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0733a f14580d;

    /* renamed from: e  reason: collision with root package name */
    public C0736a f14581e;

    /* renamed from: b.a.r.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0736a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f14582a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f14583b;

        /* renamed from: c  reason: collision with root package name */
        public e f14584c;

        /* renamed from: d  reason: collision with root package name */
        public String f14585d;

        /* renamed from: e  reason: collision with root package name */
        public String f14586e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f14587f;

        public C0736a(a aVar) {
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
            this.f14587f = aVar;
            this.f14583b = true;
            this.f14584c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14585d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f14585d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f14585d = str;
                this.f14583b = true;
            }
        }

        public void c(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || this.f14582a == j) {
                return;
            }
            this.f14582a = j;
            this.f14583b = true;
        }

        public void d(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f14586e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f14586e = str;
                this.f14583b = true;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                String g2 = this.f14587f.f14580d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f14585d = jSONObject.optString("form_id");
                    this.f14582a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f14586e = jSONObject.getString("uuid");
                    this.f14584c.b(jSONObject.getLong("flags"));
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
                if (this.f14583b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f14585d);
                        jSONObject.put("lst_fe_ts", this.f14582a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f14584c.d());
                        jSONObject.put("uuid", this.f14586e);
                        this.f14587f.f14580d.i("cache.dat", jSONObject.toString(), true);
                        this.f14583b = false;
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
        this.f14581e = new C0736a(this);
    }

    @Override // b.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14581e.a() : (String) invokeV.objValue;
    }

    @Override // b.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f14580d = this.f14555a.f(e());
            this.f14581e.e();
            if (TextUtils.isEmpty(this.f14581e.a())) {
                String uuid = UUID.randomUUID().toString();
                this.f14581e.d(uuid);
                try {
                    this.f14581e.b(b.a.r.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f14581e.c(System.currentTimeMillis());
            }
            this.f14581e.f();
        }
    }
}
