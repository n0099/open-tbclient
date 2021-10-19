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
/* loaded from: classes3.dex */
public class a extends c.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0737a f15546d;

    /* renamed from: e  reason: collision with root package name */
    public C0746a f15547e;

    /* renamed from: c.a.r.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0746a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15548a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15549b;

        /* renamed from: c  reason: collision with root package name */
        public e f15550c;

        /* renamed from: d  reason: collision with root package name */
        public String f15551d;

        /* renamed from: e  reason: collision with root package name */
        public String f15552e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15553f;

        public C0746a(a aVar) {
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
            this.f15553f = aVar;
            this.f15549b = true;
            this.f15550c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15551d : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f15551d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15551d = str;
                this.f15549b = true;
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15552e : (String) invokeV.objValue;
        }

        public void d(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) || this.f15548a == j2) {
                return;
            }
            this.f15548a = j2;
            this.f15549b = true;
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (str2 = this.f15552e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15552e = str;
                this.f15549b = true;
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                String g2 = this.f15553f.f15546d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f15551d = jSONObject.optString("form_id");
                    this.f15548a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f15552e = jSONObject.getString(Config.SSAID);
                    this.f15550c.b(jSONObject.getLong("flags"));
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
                if (this.f15549b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f15551d);
                        jSONObject.put("lst_fe_ts", this.f15548a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f15550c.d());
                        jSONObject.put(Config.SSAID, this.f15552e);
                        this.f15553f.f15546d.i("cache.dat", jSONObject.toString(), true);
                        this.f15549b = false;
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
        this.f15547e = new C0746a(this);
    }

    @Override // c.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15547e.a() : (String) invokeV.objValue;
    }

    @Override // c.a.r.h.a
    public void f(a.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            this.f15546d = this.f15477a.f(e());
            String string = Settings.Secure.getString(this.f15478b.f15482a.getContentResolver(), IAdRequestParam.ANDROID_ID);
            if (string == null) {
                string = "0";
            }
            this.f15547e.f();
            if (TextUtils.isEmpty(this.f15547e.a()) || !TextUtils.equals(string, this.f15547e.c())) {
                this.f15547e.e(string);
                try {
                    this.f15547e.b(c.a.r.h.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f15547e.d(System.currentTimeMillis());
            }
            this.f15547e.g();
        }
    }
}
