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
/* loaded from: classes3.dex */
public class a extends c.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0737a f15470d;

    /* renamed from: e  reason: collision with root package name */
    public C0740a f15471e;

    /* renamed from: c.a.r.h.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0740a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15472a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15473b;

        /* renamed from: c  reason: collision with root package name */
        public e f15474c;

        /* renamed from: d  reason: collision with root package name */
        public String f15475d;

        /* renamed from: e  reason: collision with root package name */
        public String f15476e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15477f;

        public C0740a(a aVar) {
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
            this.f15477f = aVar;
            this.f15473b = true;
            this.f15474c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15475d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f15475d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15475d = str;
                this.f15473b = true;
            }
        }

        public void c(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2) == null) || this.f15472a == j2) {
                return;
            }
            this.f15472a = j2;
            this.f15473b = true;
        }

        public void d(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || (str2 = this.f15476e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15476e = str;
                this.f15473b = true;
            }
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                String g2 = this.f15477f.f15470d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f15475d = jSONObject.optString("form_id");
                    this.f15472a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f15476e = jSONObject.getString("uuid");
                    this.f15474c.b(jSONObject.getLong("flags"));
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
                if (this.f15473b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f15475d);
                        jSONObject.put("lst_fe_ts", this.f15472a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f15474c.d());
                        jSONObject.put("uuid", this.f15476e);
                        this.f15477f.f15470d.i("cache.dat", jSONObject.toString(), true);
                        this.f15473b = false;
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
        this.f15471e = new C0740a(this);
    }

    @Override // c.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15471e.a() : (String) invokeV.objValue;
    }

    @Override // c.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f15470d = this.f15445a.f(e());
            this.f15471e.e();
            if (TextUtils.isEmpty(this.f15471e.a())) {
                String uuid = UUID.randomUUID().toString();
                this.f15471e.d(uuid);
                try {
                    this.f15471e.b(c.a.r.h.a.b("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(uuid.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f15471e.c(System.currentTimeMillis());
            }
            this.f15471e.f();
        }
    }
}
