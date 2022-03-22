package c.a.p.j.c;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import c.a.p.h.c.a.e;
import c.a.p.h.c.a.f;
import c.a.p.h.d.a;
import c.a.p.j.a;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
/* loaded from: classes2.dex */
public class a extends c.a.p.j.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0891a f11806d;

    /* renamed from: e  reason: collision with root package name */
    public b f11807e;

    /* renamed from: c.a.p.j.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0893a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public HashSet<String> a;

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f11808b;

        public C0893a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new HashSet<>();
            this.f11808b = new HashSet<>();
        }

        public static C0893a a(TrustSubject trustSubject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trustSubject)) == null) {
                try {
                    String m = trustSubject.m("config-aid");
                    if (TextUtils.isEmpty(m)) {
                        return null;
                    }
                    try {
                        C0893a c0893a = new C0893a();
                        JSONObject jSONObject = new JSONObject(m);
                        JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                c0893a.a.add(optJSONArray.getString(i));
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i2 = 0; i2 < length2; i2++) {
                                c0893a.f11808b.add(optJSONArray2.getString(i2));
                            }
                        }
                        return c0893a;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } catch (TrustSubject.ConfigNotFoundException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            return (C0893a) invokeL.objValue;
        }

        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.a.contains(str) : invokeL.booleanValue;
        }

        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f11808b.contains(str) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] a;

        /* renamed from: b  reason: collision with root package name */
        public String f11809b;

        /* renamed from: c  reason: collision with root package name */
        public String f11810c;

        /* renamed from: d  reason: collision with root package name */
        public long f11811d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f11812e;

        /* renamed from: f  reason: collision with root package name */
        public String f11813f;

        /* renamed from: g  reason: collision with root package name */
        public e f11814g;

        /* renamed from: h  reason: collision with root package name */
        public long f11815h;
        public final /* synthetic */ a i;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = aVar;
            this.f11812e = true;
            this.f11814g = new e();
        }

        public long a(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? this.f11814g.a(j) : invokeJ.longValue;
        }

        public String b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11809b : (String) invokeV.objValue;
        }

        public void c(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f11814g.c(j, j2)) {
                this.f11812e = true;
            }
        }

        public void d(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, str) == null) || str == (str2 = this.f11809b)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f11809b = str;
                this.f11812e = true;
            }
        }

        public void e(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) || Arrays.equals(bArr, this.a)) {
                return;
            }
            this.a = bArr;
            this.f11812e = true;
        }

        public String f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f11810c : (String) invokeV.objValue;
        }

        public void g(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048582, this, j) == null) || j == this.f11811d) {
                return;
            }
            this.f11811d = j;
            this.f11812e = true;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (str2 = this.f11810c) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f11810c = str;
                this.f11812e = true;
            }
        }

        public long i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f11815h : invokeV.longValue;
        }

        public void j(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048585, this, j) == null) || this.f11815h == j) {
                return;
            }
            this.f11815h = j;
            this.f11812e = true;
        }

        public void k(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || str == (str2 = this.f11813f)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f11813f = str;
                this.f11812e = true;
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
                if (this.f11812e) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("and_id", this.f11809b);
                        jSONObject.put("form_id", this.f11810c);
                        jSONObject.put("gen_ts", this.f11811d);
                        jSONObject.put("flags", this.f11814g.d());
                        jSONObject.put("c_form_ver", 1);
                        if (!TextUtils.isEmpty(this.f11813f)) {
                            jSONObject.put("ran_id", this.f11813f);
                        }
                        if (this.a != null) {
                            jSONObject.put("raw_id", Base64.encodeToString(this.a, 2));
                        }
                        jSONObject.put("lst_conf_ver", this.f11815h);
                        this.i.f11806d.i("aid.dat", jSONObject.toString(), true);
                        this.f11812e = false;
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
                String g2 = this.i.f11806d.g("aid.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.a = Base64.decode(jSONObject.getString("raw_id"), 2);
                        this.f11811d = jSONObject.getLong("gen_ts");
                        this.f11810c = jSONObject.getString("form_id");
                        this.f11809b = jSONObject.getString("and_id");
                        this.f11813f = jSONObject.optString("ran_id", null);
                        this.f11814g.b(jSONObject.getLong("flags"));
                        this.f11815h = jSONObject.getLong("lst_conf_ver");
                        jSONObject.getInt("c_form_ver");
                        this.f11812e = false;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f11807e = new b(this);
    }

    public static String i(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? c.a.p.j.a.b("A00", new c.a.p.h.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(bArr)) : (String) invokeL.objValue;
    }

    @Override // c.a.p.j.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f11807e.f() : (String) invokeV.objValue;
    }

    @Override // c.a.p.j.a
    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f11807e.l() : (byte[]) invokeV.objValue;
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
    @Override // c.a.p.j.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(a.b bVar) {
        long j;
        boolean z;
        boolean z2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            this.f11806d = this.a.f("aid");
            this.f11807e.n();
            TrustSubject trustSubject = this.f11799b.f11802c.f25579b;
            boolean z3 = false;
            boolean z4 = true;
            if (trustSubject != null) {
                j = trustSubject.n();
                if (j != this.f11807e.i()) {
                    z = true;
                    z2 = !TextUtils.isEmpty(this.f11807e.f()) || this.f11807e.l() == null || TextUtils.isEmpty(this.f11807e.b());
                    if (!z2 || z) {
                        str = null;
                        C0893a a = trustSubject == null ? C0893a.a(trustSubject) : null;
                        str = Settings.Secure.getString(this.f11799b.a.getContentResolver(), HttpRequest.ANDROID_ID);
                        if (TextUtils.isEmpty(str)) {
                            str = "000000000";
                        }
                        if (z2) {
                            if (a != null) {
                                if (this.f11807e.a(1L) == 0) {
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
                                this.f11807e.k(uuid);
                                str2 = str2 + uuid;
                                this.f11807e.c(1L, 1L);
                            }
                            byte[] a2 = f.a(str2, IMAudioTransRequest.CHARSET);
                            String i = i(a2);
                            this.f11807e.e(a2);
                            this.f11807e.g(System.currentTimeMillis());
                            this.f11807e.d(str);
                            this.f11807e.h(i);
                        }
                        this.f11807e.j(j);
                        this.f11807e.m();
                    }
                    return;
                }
            } else {
                j = 0;
            }
            z = false;
            if (TextUtils.isEmpty(this.f11807e.f())) {
            }
            if (z2) {
            }
            str = null;
            if (trustSubject == null) {
            }
            str = Settings.Secure.getString(this.f11799b.a.getContentResolver(), HttpRequest.ANDROID_ID);
            if (TextUtils.isEmpty(str)) {
            }
            if (z2) {
            }
            if (z3) {
            }
            this.f11807e.j(j);
            this.f11807e.m();
        }
    }
}
