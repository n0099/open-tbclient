package c.a.r.h.g;

import android.provider.Settings;
import android.text.TextUtils;
import c.a.r.g.c.a.b;
import c.a.r.g.c.a.e;
import c.a.r.g.d.a;
import c.a.r.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.dxmpay.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends c.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1379a f29684d;

    /* renamed from: e  reason: collision with root package name */
    public C1388a f29685e;

    /* renamed from: c.a.r.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1388a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f29686a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f29687b;

        /* renamed from: c  reason: collision with root package name */
        public e f29688c;

        /* renamed from: d  reason: collision with root package name */
        public String f29689d;

        /* renamed from: e  reason: collision with root package name */
        public String f29690e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f29691f;

        public C1388a(a aVar) {
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
            this.f29691f = aVar;
            this.f29687b = true;
            this.f29688c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29689d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f29689d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f29689d = str;
                this.f29687b = true;
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f29690e : (String) invokeV.objValue;
        }

        public void d(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || this.f29686a == j2) {
                return;
            }
            this.f29686a = j2;
            this.f29687b = true;
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (str2 = this.f29690e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f29690e = str;
                this.f29687b = true;
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                String g2 = this.f29691f.f29684d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f29689d = jSONObject.optString("form_id");
                    this.f29686a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f29690e = jSONObject.getString(Config.SSAID);
                    this.f29688c.b(jSONObject.getLong("flags"));
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        public boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (this.f29687b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f29689d);
                        jSONObject.put("lst_fe_ts", this.f29686a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f29688c.d());
                        jSONObject.put(Config.SSAID, this.f29690e);
                        this.f29691f.f29684d.i("cache.dat", jSONObject.toString(), true);
                        this.f29687b = false;
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
        this.f29685e = new C1388a(this);
    }

    @Override // c.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29685e.a() : (String) invokeV.objValue;
    }

    @Override // c.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f29684d = this.f29615a.f(e());
            String string = Settings.Secure.getString(this.f29616b.f29620a.getContentResolver(), IAdRequestParam.ANDROID_ID);
            if (string == null) {
                string = "0";
            }
            this.f29685e.f();
            if (TextUtils.isEmpty(this.f29685e.a()) || !TextUtils.equals(string, this.f29685e.c())) {
                this.f29685e.e(string);
                try {
                    this.f29685e.b(c.a.r.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f29685e.d(System.currentTimeMillis());
            }
            this.f29685e.g();
        }
    }
}
