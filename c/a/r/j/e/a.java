package c.a.r.j.e;

import android.text.TextUtils;
import c.a.r.h.c.a.b;
import c.a.r.h.c.a.e;
import c.a.r.h.d.a;
import c.a.r.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.r.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0259a f5135d;

    /* renamed from: e  reason: collision with root package name */
    public C0262a f5136e;

    /* renamed from: c.a.r.j.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0262a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5137b;

        /* renamed from: c  reason: collision with root package name */
        public e f5138c;

        /* renamed from: d  reason: collision with root package name */
        public String f5139d;

        /* renamed from: e  reason: collision with root package name */
        public String f5140e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5141f;

        public C0262a(a aVar) {
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
            this.f5141f = aVar;
            this.f5137b = true;
            this.f5138c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5139d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f5139d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f5139d = str;
                this.f5137b = true;
            }
        }

        public void c(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) || this.a == j2) {
                return;
            }
            this.a = j2;
            this.f5137b = true;
        }

        public void d(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f5140e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f5140e = str;
                this.f5137b = true;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.f5137b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f5139d);
                        jSONObject.put("lst_fe_ts", this.a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f5138c.d());
                        jSONObject.put("uuid", this.f5140e);
                        this.f5141f.f5135d.i("cache.dat", jSONObject.toString(), true);
                        this.f5137b = false;
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
                String g2 = this.f5141f.f5135d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f5139d = jSONObject.optString("form_id");
                    this.a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f5140e = jSONObject.getString("uuid");
                    this.f5138c.b(jSONObject.getLong("flags"));
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
        this.f5136e = new C0262a(this);
    }

    @Override // c.a.r.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5136e.a() : (String) invokeV.objValue;
    }

    @Override // c.a.r.j.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f5135d = this.a.f(e());
            this.f5136e.f();
            if (TextUtils.isEmpty(this.f5136e.a())) {
                String uuid = UUID.randomUUID().toString();
                this.f5136e.d(uuid);
                try {
                    this.f5136e.b(c.a.r.j.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f5136e.c(System.currentTimeMillis());
            }
            this.f5136e.e();
        }
    }
}
