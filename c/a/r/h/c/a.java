package c.a.r.h.c;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import c.a.r.g.c.a.e;
import c.a.r.g.c.a.f;
import c.a.r.g.d.a;
import c.a.r.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.helios.trusts.zone.TrustSubject;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
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
/* loaded from: classes4.dex */
public class a extends c.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C1379a f29627d;

    /* renamed from: e  reason: collision with root package name */
    public b f29628e;

    /* renamed from: c.a.r.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C1381a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HashSet<String> f29629a;

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f29630b;

        public C1381a() {
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
            this.f29629a = new HashSet<>();
            this.f29630b = new HashSet<>();
        }

        public static C1381a a(TrustSubject trustSubject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trustSubject)) == null) {
                try {
                    String m = trustSubject.m("config-aid");
                    if (TextUtils.isEmpty(m)) {
                        return null;
                    }
                    try {
                        C1381a c1381a = new C1381a();
                        JSONObject jSONObject = new JSONObject(m);
                        JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                c1381a.f29629a.add(optJSONArray.getString(i2));
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                c1381a.f29630b.add(optJSONArray2.getString(i3));
                            }
                        }
                        return c1381a;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } catch (TrustSubject.ConfigNotFoundException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            return (C1381a) invokeL.objValue;
        }

        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f29629a.contains(str) : invokeL.booleanValue;
        }

        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f29630b.contains(str) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public byte[] f29631a;

        /* renamed from: b  reason: collision with root package name */
        public String f29632b;

        /* renamed from: c  reason: collision with root package name */
        public String f29633c;

        /* renamed from: d  reason: collision with root package name */
        public long f29634d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f29635e;

        /* renamed from: f  reason: collision with root package name */
        public String f29636f;

        /* renamed from: g  reason: collision with root package name */
        public e f29637g;

        /* renamed from: h  reason: collision with root package name */
        public long f29638h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f29639i;

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
            this.f29639i = aVar;
            this.f29635e = true;
            this.f29637g = new e();
        }

        public void a(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) || j2 == this.f29634d) {
                return;
            }
            this.f29634d = j2;
            this.f29635e = true;
        }

        public void b(long j2, long j3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) && this.f29637g.c(j2, j3)) {
                this.f29635e = true;
            }
        }

        public void c(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == (str2 = this.f29632b)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f29632b = str;
                this.f29635e = true;
            }
        }

        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) || Arrays.equals(bArr, this.f29631a)) {
                return;
            }
            this.f29631a = bArr;
            this.f29635e = true;
        }

        public byte[] e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f29631a : (byte[]) invokeV.objValue;
        }

        public long f(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) ? this.f29637g.a(j2) : invokeJ.longValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f29632b : (String) invokeV.objValue;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (str2 = this.f29633c) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f29633c = str;
                this.f29635e = true;
            }
        }

        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f29633c : (String) invokeV.objValue;
        }

        public void j(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) || this.f29638h == j2) {
                return;
            }
            this.f29638h = j2;
            this.f29635e = true;
        }

        public void k(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || str == (str2 = this.f29636f)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f29636f = str;
                this.f29635e = true;
            }
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f29638h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                String g2 = this.f29639i.f29627d.g("aid.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f29631a = Base64.decode(jSONObject.getString("raw_id"), 2);
                        this.f29634d = jSONObject.getLong("gen_ts");
                        this.f29633c = jSONObject.getString("form_id");
                        this.f29632b = jSONObject.getString("and_id");
                        this.f29636f = jSONObject.optString("ran_id", null);
                        this.f29637g.b(jSONObject.getLong("flags"));
                        this.f29638h = jSONObject.getLong("lst_conf_ver");
                        jSONObject.getInt("c_form_ver");
                        this.f29635e = false;
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
                if (this.f29635e) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("and_id", this.f29632b);
                        jSONObject.put("form_id", this.f29633c);
                        jSONObject.put("gen_ts", this.f29634d);
                        jSONObject.put("flags", this.f29637g.d());
                        jSONObject.put("c_form_ver", 1);
                        if (!TextUtils.isEmpty(this.f29636f)) {
                            jSONObject.put("ran_id", this.f29636f);
                        }
                        if (this.f29631a != null) {
                            jSONObject.put("raw_id", Base64.encodeToString(this.f29631a, 2));
                        }
                        jSONObject.put("lst_conf_ver", this.f29638h);
                        this.f29639i.f29627d.i("aid.dat", jSONObject.toString(), true);
                        this.f29635e = false;
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
        this.f29628e = new b(this);
    }

    public static String i(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? c.a.r.h.a.b("A00", new c.a.r.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(bArr)) : (String) invokeL.objValue;
    }

    @Override // c.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29628e.i() : (String) invokeV.objValue;
    }

    @Override // c.a.r.h.a
    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f29628e.e() : (byte[]) invokeV.objValue;
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
    @Override // c.a.r.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(a.c cVar) {
        long j2;
        boolean z;
        boolean z2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f29627d = this.f29615a.f("aid");
            this.f29628e.m();
            TrustSubject trustSubject = this.f29616b.f29622c.f40479b;
            boolean z3 = false;
            boolean z4 = true;
            if (trustSubject != null) {
                j2 = trustSubject.n();
                if (j2 != this.f29628e.l()) {
                    z = true;
                    z2 = !TextUtils.isEmpty(this.f29628e.i()) || this.f29628e.e() == null || TextUtils.isEmpty(this.f29628e.g());
                    if (!z2 || z) {
                        str = null;
                        C1381a a2 = trustSubject == null ? C1381a.a(trustSubject) : null;
                        str = Settings.Secure.getString(this.f29616b.f29620a.getContentResolver(), IAdRequestParam.ANDROID_ID);
                        if (TextUtils.isEmpty(str)) {
                            str = "000000000";
                        }
                        if (z2) {
                            if (a2 != null) {
                                if (this.f29628e.f(1L) == 0) {
                                }
                            }
                            z4 = false;
                        } else {
                            if (a2 == null || !a2.b(str)) {
                                z3 = true;
                                z4 = false;
                            }
                            z3 = true;
                        }
                        if (z3) {
                            String str2 = "com.helios" + str;
                            if (z4) {
                                String uuid = UUID.randomUUID().toString();
                                this.f29628e.k(uuid);
                                str2 = str2 + uuid;
                                this.f29628e.b(1L, 1L);
                            }
                            byte[] a3 = f.a(str2, "utf-8");
                            String i2 = i(a3);
                            this.f29628e.d(a3);
                            this.f29628e.a(System.currentTimeMillis());
                            this.f29628e.c(str);
                            this.f29628e.h(i2);
                        }
                        this.f29628e.j(j2);
                        this.f29628e.n();
                    }
                    return;
                }
            } else {
                j2 = 0;
            }
            z = false;
            if (TextUtils.isEmpty(this.f29628e.i())) {
            }
            if (z2) {
            }
            str = null;
            if (trustSubject == null) {
            }
            str = Settings.Secure.getString(this.f29616b.f29620a.getContentResolver(), IAdRequestParam.ANDROID_ID);
            if (TextUtils.isEmpty(str)) {
            }
            if (z2) {
            }
            if (z3) {
            }
            this.f29628e.j(j2);
            this.f29628e.n();
        }
    }
}
