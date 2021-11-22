package b.a.r.j.e;

import android.text.TextUtils;
import b.a.r.h.c.a.b;
import b.a.r.h.c.a.e;
import b.a.r.h.d.a;
import b.a.r.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends b.a.r.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0774a f15407d;

    /* renamed from: e  reason: collision with root package name */
    public C0777a f15408e;

    /* renamed from: b.a.r.j.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0777a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15409a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15410b;

        /* renamed from: c  reason: collision with root package name */
        public e f15411c;

        /* renamed from: d  reason: collision with root package name */
        public String f15412d;

        /* renamed from: e  reason: collision with root package name */
        public String f15413e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15414f;

        public C0777a(a aVar) {
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
            this.f15414f = aVar;
            this.f15410b = true;
            this.f15411c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15412d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f15412d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15412d = str;
                this.f15410b = true;
            }
        }

        public void c(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) || this.f15409a == j) {
                return;
            }
            this.f15409a = j;
            this.f15410b = true;
        }

        public void d(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f15413e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15413e = str;
                this.f15410b = true;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f15410b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f15412d);
                        jSONObject.put("lst_fe_ts", this.f15409a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f15411c.d());
                        jSONObject.put("uuid", this.f15413e);
                        this.f15414f.f15407d.i("cache.dat", jSONObject.toString(), true);
                        this.f15410b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                String g2 = this.f15414f.f15407d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f15412d = jSONObject.optString("form_id");
                    this.f15409a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f15413e = jSONObject.getString("uuid");
                    this.f15411c.b(jSONObject.getLong("flags"));
                    return true;
                } catch (Exception unused) {
                    return false;
                }
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
        this.f15408e = new C0777a(this);
    }

    @Override // b.a.r.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15408e.a() : (String) invokeV.objValue;
    }

    @Override // b.a.r.j.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f15407d = this.f15382a.f(e());
            this.f15408e.f();
            if (TextUtils.isEmpty(this.f15408e.a())) {
                String uuid = UUID.randomUUID().toString();
                this.f15408e.d(uuid);
                try {
                    this.f15408e.b(b.a.r.j.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f15408e.c(System.currentTimeMillis());
            }
            this.f15408e.e();
        }
    }
}
