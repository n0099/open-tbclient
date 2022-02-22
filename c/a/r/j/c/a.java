package c.a.r.j.c;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import c.a.r.h.c.a.e;
import c.a.r.h.c.a.f;
import c.a.r.h.d.a;
import c.a.r.j.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a extends c.a.r.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0264a f5194d;

    /* renamed from: e  reason: collision with root package name */
    public b f5195e;

    /* renamed from: c.a.r.j.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0266a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashSet<String> a;

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f5196b;

        public C0266a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new HashSet<>();
            this.f5196b = new HashSet<>();
        }

        public static C0266a a(TrustSubject trustSubject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trustSubject)) == null) {
                try {
                    String m = trustSubject.m("config-aid");
                    if (TextUtils.isEmpty(m)) {
                        return null;
                    }
                    try {
                        C0266a c0266a = new C0266a();
                        JSONObject jSONObject = new JSONObject(m);
                        JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                c0266a.a.add(optJSONArray.getString(i2));
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                c0266a.f5196b.add(optJSONArray2.getString(i3));
                            }
                        }
                        return c0266a;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } catch (TrustSubject.ConfigNotFoundException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            return (C0266a) invokeL.objValue;
        }

        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.contains(str) : invokeL.booleanValue;
        }

        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f5196b.contains(str) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public String f5197b;

        /* renamed from: c  reason: collision with root package name */
        public String f5198c;

        /* renamed from: d  reason: collision with root package name */
        public long f5199d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5200e;

        /* renamed from: f  reason: collision with root package name */
        public String f5201f;

        /* renamed from: g  reason: collision with root package name */
        public e f5202g;

        /* renamed from: h  reason: collision with root package name */
        public long f5203h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f5204i;

        public b(a aVar) {
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
            this.f5204i = aVar;
            this.f5200e = true;
            this.f5202g = new e();
        }

        public long a(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j2)) == null) ? this.f5202g.a(j2) : invokeJ.longValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5197b : (String) invokeV.objValue;
        }

        public void c(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f5202g.c(j2, j3)) {
                this.f5200e = true;
            }
        }

        public void d(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str == (str2 = this.f5197b)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f5197b = str;
                this.f5200e = true;
            }
        }

        public void e(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) || Arrays.equals(bArr, this.a)) {
                return;
            }
            this.a = bArr;
            this.f5200e = true;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f5198c : (String) invokeV.objValue;
        }

        public void g(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) || j2 == this.f5199d) {
                return;
            }
            this.f5199d = j2;
            this.f5200e = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (str2 = this.f5198c) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f5198c = str;
                this.f5200e = true;
            }
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f5203h : invokeV.longValue;
        }

        public void j(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) || this.f5203h == j2) {
                return;
            }
            this.f5203h = j2;
            this.f5200e = true;
        }

        public void k(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || str == (str2 = this.f5201f)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f5201f = str;
                this.f5200e = true;
            }
        }

        public byte[] l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.a : (byte[]) invokeV.objValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                if (this.f5200e) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("and_id", this.f5197b);
                        jSONObject.put("form_id", this.f5198c);
                        jSONObject.put("gen_ts", this.f5199d);
                        jSONObject.put("flags", this.f5202g.d());
                        jSONObject.put("c_form_ver", 1);
                        if (!TextUtils.isEmpty(this.f5201f)) {
                            jSONObject.put("ran_id", this.f5201f);
                        }
                        if (this.a != null) {
                            jSONObject.put("raw_id", Base64.encodeToString(this.a, 2));
                        }
                        jSONObject.put("lst_conf_ver", this.f5203h);
                        this.f5204i.f5194d.i("aid.dat", jSONObject.toString(), true);
                        this.f5200e = false;
                        return true;
                    } catch (Exception unused) {
                    }
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean n() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                String g2 = this.f5204i.f5194d.g("aid.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.a = Base64.decode(jSONObject.getString("raw_id"), 2);
                        this.f5199d = jSONObject.getLong("gen_ts");
                        this.f5198c = jSONObject.getString("form_id");
                        this.f5197b = jSONObject.getString("and_id");
                        this.f5201f = jSONObject.optString("ran_id", null);
                        this.f5202g.b(jSONObject.getLong("flags"));
                        this.f5203h = jSONObject.getLong("lst_conf_ver");
                        jSONObject.getInt("c_form_ver");
                        this.f5200e = false;
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
        super("aid");
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
        this.f5195e = new b(this);
    }

    public static String i(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? c.a.r.j.a.b("A00", new c.a.r.h.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(bArr)) : (String) invokeL.objValue;
    }

    @Override // c.a.r.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f5195e.f() : (String) invokeV.objValue;
    }

    @Override // c.a.r.j.a
    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f5195e.l() : (byte[]) invokeV.objValue;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:3|(2:5|(4:7|8|(1:51)(1:14)|(12:19|(1:21)(1:50)|22|23|24|25|(1:27)|28|(2:(2:41|42)|33)(2:(2:44|(1:46))|42)|(3:35|(1:37)|38)|39|40)(1:17)))(1:53)|52|8|(1:10)|51|(0)|19|(0)(0)|22|23|24|25|(0)|28|(0)(0)|(0)|39|40) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
        if (r13.c(r6) != false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a1  */
    @Override // c.a.r.j.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(a.b bVar) {
        long j2;
        boolean z;
        boolean z2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f5194d = this.a.f("aid");
            this.f5195e.n();
            TrustSubject trustSubject = this.f5186b.f5189c.f34822b;
            boolean z3 = false;
            boolean z4 = true;
            if (trustSubject != null) {
                j2 = trustSubject.n();
                if (j2 != this.f5195e.i()) {
                    z = true;
                    z2 = !TextUtils.isEmpty(this.f5195e.f()) || this.f5195e.l() == null || TextUtils.isEmpty(this.f5195e.b());
                    if (!z2 || z) {
                        str = null;
                        C0266a a = trustSubject == null ? C0266a.a(trustSubject) : null;
                        str = Settings.Secure.getString(this.f5186b.a.getContentResolver(), HttpRequest.ANDROID_ID);
                        if (TextUtils.isEmpty(str)) {
                            str = "000000000";
                        }
                        if (z2) {
                            if (a != null) {
                                if (this.f5195e.a(1L) == 0) {
                                }
                            }
                            z4 = false;
                        } else {
                            if (a == null || !a.b(str)) {
                                z3 = true;
                                z4 = false;
                            }
                            z3 = true;
                        }
                        if (z3) {
                            String str2 = "com.helios" + str;
                            if (z4) {
                                String uuid = UUID.randomUUID().toString();
                                this.f5195e.k(uuid);
                                str2 = str2 + uuid;
                                this.f5195e.c(1L, 1L);
                            }
                            byte[] a2 = f.a(str2, "utf-8");
                            String i2 = i(a2);
                            this.f5195e.e(a2);
                            this.f5195e.g(System.currentTimeMillis());
                            this.f5195e.d(str);
                            this.f5195e.h(i2);
                        }
                        this.f5195e.j(j2);
                        this.f5195e.m();
                    }
                    return;
                }
            } else {
                j2 = 0;
            }
            z = false;
            if (TextUtils.isEmpty(this.f5195e.f())) {
            }
            if (z2) {
            }
            str = null;
            if (trustSubject == null) {
            }
            str = Settings.Secure.getString(this.f5186b.a.getContentResolver(), HttpRequest.ANDROID_ID);
            if (TextUtils.isEmpty(str)) {
            }
            if (z2) {
            }
            if (z3) {
            }
            this.f5195e.j(j2);
            this.f5195e.m();
        }
    }
}
