package b.a.r.h.g;

import android.provider.Settings;
import android.text.TextUtils;
import b.a.r.g.c.a.b;
import b.a.r.g.c.a.e;
import b.a.r.g.d.a;
import b.a.r.h.a;
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
public class a extends b.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0733a f14623d;

    /* renamed from: e  reason: collision with root package name */
    public C0742a f14624e;

    /* renamed from: b.a.r.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0742a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f14625a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f14626b;

        /* renamed from: c  reason: collision with root package name */
        public e f14627c;

        /* renamed from: d  reason: collision with root package name */
        public String f14628d;

        /* renamed from: e  reason: collision with root package name */
        public String f14629e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f14630f;

        public C0742a(a aVar) {
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
            this.f14630f = aVar;
            this.f14626b = true;
            this.f14627c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14628d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f14628d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f14628d = str;
                this.f14626b = true;
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f14629e : (String) invokeV.objValue;
        }

        public void d(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.f14625a == j) {
                return;
            }
            this.f14625a = j;
            this.f14626b = true;
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (str2 = this.f14629e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f14629e = str;
                this.f14626b = true;
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                String g2 = this.f14630f.f14623d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f14628d = jSONObject.optString("form_id");
                    this.f14625a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f14629e = jSONObject.getString(Config.SSAID);
                    this.f14627c.b(jSONObject.getLong("flags"));
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
                if (this.f14626b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f14628d);
                        jSONObject.put("lst_fe_ts", this.f14625a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f14627c.d());
                        jSONObject.put(Config.SSAID, this.f14629e);
                        this.f14630f.f14623d.i("cache.dat", jSONObject.toString(), true);
                        this.f14626b = false;
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
        this.f14624e = new C0742a(this);
    }

    @Override // b.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14624e.a() : (String) invokeV.objValue;
    }

    @Override // b.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f14623d = this.f14555a.f(e());
            String string = Settings.Secure.getString(this.f14556b.f14560a.getContentResolver(), IAdRequestParam.ANDROID_ID);
            if (string == null) {
                string = "0";
            }
            this.f14624e.f();
            if (TextUtils.isEmpty(this.f14624e.a()) || !TextUtils.equals(string, this.f14624e.c())) {
                this.f14624e.e(string);
                try {
                    this.f14624e.b(b.a.r.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f14624e.d(System.currentTimeMillis());
            }
            this.f14624e.g();
        }
    }
}
