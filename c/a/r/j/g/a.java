package c.a.r.j.g;

import android.provider.Settings;
import android.text.TextUtils;
import c.a.r.h.c.a.b;
import c.a.r.h.c.a.e;
import c.a.r.h.d.a;
import c.a.r.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.r.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0259a f5179d;

    /* renamed from: e  reason: collision with root package name */
    public C0267a f5180e;

    /* renamed from: c.a.r.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0267a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5181b;

        /* renamed from: c  reason: collision with root package name */
        public e f5182c;

        /* renamed from: d  reason: collision with root package name */
        public String f5183d;

        /* renamed from: e  reason: collision with root package name */
        public String f5184e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5185f;

        public C0267a(a aVar) {
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
            this.f5185f = aVar;
            this.f5181b = true;
            this.f5182c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5184e : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f5184e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f5184e = str;
                this.f5181b = true;
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f5183d : (String) invokeV.objValue;
        }

        public void d(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || this.a == j2) {
                return;
            }
            this.a = j2;
            this.f5181b = true;
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (str2 = this.f5183d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f5183d = str;
                this.f5181b = true;
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f5181b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f5183d);
                        jSONObject.put("lst_fe_ts", this.a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f5182c.d());
                        jSONObject.put(Config.SSAID, this.f5184e);
                        this.f5185f.f5179d.i("cache.dat", jSONObject.toString(), true);
                        this.f5181b = false;
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
                String g2 = this.f5185f.f5179d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f5183d = jSONObject.optString("form_id");
                    this.a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f5184e = jSONObject.getString(Config.SSAID);
                    this.f5182c.b(jSONObject.getLong("flags"));
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
        this.f5180e = new C0267a(this);
    }

    @Override // c.a.r.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5180e.c() : (String) invokeV.objValue;
    }

    @Override // c.a.r.j.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f5179d = this.a.f(e());
            String string = Settings.Secure.getString(this.f5116b.a.getContentResolver(), HttpRequest.ANDROID_ID);
            if (string == null) {
                string = "0";
            }
            this.f5180e.g();
            if (TextUtils.isEmpty(this.f5180e.c()) || !TextUtils.equals(string, this.f5180e.a())) {
                this.f5180e.b(string);
                try {
                    this.f5180e.e(c.a.r.j.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f5180e.d(System.currentTimeMillis());
            }
            this.f5180e.f();
        }
    }
}
