package b.a.r.j.g;

import android.provider.Settings;
import android.text.TextUtils;
import b.a.r.h.c.a.b;
import b.a.r.h.c.a.e;
import b.a.r.h.d.a;
import b.a.r.j.a;
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
public class a extends b.a.r.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0774a f15455d;

    /* renamed from: e  reason: collision with root package name */
    public C0782a f15456e;

    /* renamed from: b.a.r.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0782a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f15457a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f15458b;

        /* renamed from: c  reason: collision with root package name */
        public e f15459c;

        /* renamed from: d  reason: collision with root package name */
        public String f15460d;

        /* renamed from: e  reason: collision with root package name */
        public String f15461e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f15462f;

        public C0782a(a aVar) {
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
            this.f15462f = aVar;
            this.f15458b = true;
            this.f15459c = new e();
        }

        public String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15461e : (String) invokeV.objValue;
        }

        public void b(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || (str2 = this.f15461e) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15461e = str;
                this.f15458b = true;
            }
        }

        public String c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f15460d : (String) invokeV.objValue;
        }

        public void d(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048579, this, j) == null) || this.f15457a == j) {
                return;
            }
            this.f15457a = j;
            this.f15458b = true;
        }

        public void e(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, str) == null) || (str2 = this.f15460d) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f15460d = str;
                this.f15458b = true;
            }
        }

        public boolean f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.f15458b) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("form_id", this.f15460d);
                        jSONObject.put("lst_fe_ts", this.f15457a);
                        jSONObject.put("c_form_ver", 1);
                        jSONObject.put("flags", this.f15459c.d());
                        jSONObject.put(Config.SSAID, this.f15461e);
                        this.f15462f.f15455d.i("cache.dat", jSONObject.toString(), true);
                        this.f15458b = false;
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
                String g2 = this.f15462f.f15455d.g("cache.dat", true);
                if (TextUtils.isEmpty(g2)) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(g2);
                    this.f15460d = jSONObject.optString("form_id");
                    this.f15457a = jSONObject.getLong("lst_fe_ts");
                    jSONObject.getInt("c_form_ver");
                    this.f15461e = jSONObject.getString(Config.SSAID);
                    this.f15459c.b(jSONObject.getLong("flags"));
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
        this.f15456e = new C0782a(this);
    }

    @Override // b.a.r.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f15456e.c() : (String) invokeV.objValue;
    }

    @Override // b.a.r.j.a
    public void f(a.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f15455d = this.f15382a.f(e());
            String string = Settings.Secure.getString(this.f15383b.f15385a.getContentResolver(), IAdRequestParam.ANDROID_ID);
            if (string == null) {
                string = "0";
            }
            this.f15456e.g();
            if (TextUtils.isEmpty(this.f15456e.c()) || !TextUtils.equals(string, this.f15456e.a())) {
                this.f15456e.b(string);
                try {
                    this.f15456e.e(b.a.r.j.a.b("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(string.getBytes("UTF-8"))));
                } catch (Exception unused) {
                }
                this.f15456e.d(System.currentTimeMillis());
            }
            this.f15456e.f();
        }
    }
}
