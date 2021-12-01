package c.a.q.j.g;

import android.provider.Settings;
import android.text.TextUtils;
import c.a.q.h.c.a.b;
import c.a.q.h.c.a.e;
import c.a.q.h.d.a;
import c.a.q.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a extends c.a.q.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0742a f11549d;

    /* renamed from: e  reason: collision with root package name */
    public C0750a f11550e;

    /* renamed from: c.a.q.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0750a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11551b;

        /* renamed from: c  reason: collision with root package name */
        public e f11552c;

        /* renamed from: d  reason: collision with root package name */
        public String f11553d;

        /* renamed from: e  reason: collision with root package name */
        public String f11554e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f11555f;

        public C0750a(a aVar) {
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
            this.f11555f = aVar;
            this.f11551b = true;
            this.f11552c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11554e : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f11554e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f11554e = str;
                this.f11551b = true;
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f11553d : (String) invokeV.objValue;
        }

        public void d(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || this.a == j2) {
                return;
            }
            this.a = j2;
            this.f11551b = true;
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (str2 = this.f11553d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f11553d = str;
                this.f11551b = true;
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f11551b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f11553d);
                        jSONObject.put("lst_fe_ts", this.a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f11552c.d());
                        jSONObject.put(Config.SSAID, this.f11554e);
                        this.f11555f.f11549d.i("cache.dat", jSONObject.toString(), true);
                        this.f11551b = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                String g2 = this.f11555f.f11549d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f11553d = jSONObject.optString("form_id");
                    this.a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f11554e = jSONObject.getString(Config.SSAID);
                    this.f11552c.b(jSONObject.getLong("flags"));
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
        super(Config.SSAID);
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
        this.f11550e = new C0750a(this);
    }

    @Override // c.a.q.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11550e.c() : (String) invokeV.objValue;
    }

    @Override // c.a.q.j.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f11549d = this.a.f(e());
            String string = Settings.Secure.getString(this.f11485b.a.getContentResolver(), "android_id");
            if (string == null) {
                string = "0";
            }
            this.f11550e.g();
            if (TextUtils.isEmpty(this.f11550e.c()) || !TextUtils.equals(string, this.f11550e.a())) {
                this.f11550e.b(string);
                try {
                    this.f11550e.e(c.a.q.j.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f11550e.d(System.currentTimeMillis());
            }
            this.f11550e.f();
        }
    }
}
