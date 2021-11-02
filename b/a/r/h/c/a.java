package b.a.r.h.c;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import b.a.r.g.c.a.e;
import b.a.r.g.c.a.f;
import b.a.r.g.d.a;
import b.a.r.h.a;
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
public class a extends b.a.r.h.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public a.C0733a f14567d;

    /* renamed from: e  reason: collision with root package name */
    public b f14568e;

    /* renamed from: b.a.r.h.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0735a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public HashSet<String> f14569a;

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f14570b;

        public C0735a() {
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
            this.f14569a = new HashSet<>();
            this.f14570b = new HashSet<>();
        }

        public static C0735a a(TrustSubject trustSubject) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, trustSubject)) == null) {
                try {
                    String m = trustSubject.m("config-aid");
                    if (TextUtils.isEmpty(m)) {
                        return null;
                    }
                    try {
                        C0735a c0735a = new C0735a();
                        JSONObject jSONObject = new JSONObject(m);
                        JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                c0735a.f14569a.add(optJSONArray.getString(i2));
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i3 = 0; i3 < length2; i3++) {
                                c0735a.f14570b.add(optJSONArray2.getString(i3));
                            }
                        }
                        return c0735a;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        return null;
                    }
                } catch (TrustSubject.ConfigNotFoundException e3) {
                    e3.printStackTrace();
                    return null;
                }
            }
            return (C0735a) invokeL.objValue;
        }

        public boolean b(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.f14569a.contains(str) : invokeL.booleanValue;
        }

        public boolean c(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? this.f14570b.contains(str) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public byte[] f14571a;

        /* renamed from: b  reason: collision with root package name */
        public String f14572b;

        /* renamed from: c  reason: collision with root package name */
        public String f14573c;

        /* renamed from: d  reason: collision with root package name */
        public long f14574d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f14575e;

        /* renamed from: f  reason: collision with root package name */
        public String f14576f;

        /* renamed from: g  reason: collision with root package name */
        public e f14577g;

        /* renamed from: h  reason: collision with root package name */
        public long f14578h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f14579i;

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
            this.f14579i = aVar;
            this.f14575e = true;
            this.f14577g = new e();
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048576, this, j) == null) || j == this.f14574d) {
                return;
            }
            this.f14574d = j;
            this.f14575e = true;
        }

        public void b(long j, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) && this.f14577g.c(j, j2)) {
                this.f14575e = true;
            }
        }

        public void c(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) || str == (str2 = this.f14572b)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f14572b = str;
                this.f14575e = true;
            }
        }

        public void d(byte[] bArr) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bArr) == null) || Arrays.equals(bArr, this.f14571a)) {
                return;
            }
            this.f14571a = bArr;
            this.f14575e = true;
        }

        public byte[] e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f14571a : (byte[]) invokeV.objValue;
        }

        public long f(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) ? this.f14577g.a(j) : invokeJ.longValue;
        }

        public String g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f14572b : (String) invokeV.objValue;
        }

        public void h(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048583, this, str) == null) || (str2 = this.f14573c) == str) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f14573c = str;
                this.f14575e = true;
            }
        }

        public String i() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f14573c : (String) invokeV.objValue;
        }

        public void j(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(1048585, this, j) == null) || this.f14578h == j) {
                return;
            }
            this.f14578h = j;
            this.f14575e = true;
        }

        public void k(String str) {
            String str2;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || str == (str2 = this.f14576f)) {
                return;
            }
            if (str == null || !str.equals(str2)) {
                this.f14576f = str;
                this.f14575e = true;
            }
        }

        public long l() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f14578h : invokeV.longValue;
        }

        public boolean m() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                String g2 = this.f14579i.f14567d.g("aid.dat", true);
                if (!TextUtils.isEmpty(g2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(g2);
                        this.f14571a = Base64.decode(jSONObject.getString("raw_id"), 2);
                        this.f14574d = jSONObject.getLong("gen_ts");
                        this.f14573c = jSONObject.getString("form_id");
                        this.f14572b = jSONObject.getString("and_id");
                        this.f14576f = jSONObject.optString("ran_id", null);
                        this.f14577g.b(jSONObject.getLong("flags"));
                        this.f14578h = jSONObject.getLong("lst_conf_ver");
                        jSONObject.getInt("c_form_ver");
                        this.f14575e = false;
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
                if (this.f14575e) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("and_id", this.f14572b);
                        jSONObject.put("form_id", this.f14573c);
                        jSONObject.put("gen_ts", this.f14574d);
                        jSONObject.put("flags", this.f14577g.d());
                        jSONObject.put("c_form_ver", 1);
                        if (!TextUtils.isEmpty(this.f14576f)) {
                            jSONObject.put("ran_id", this.f14576f);
                        }
                        if (this.f14571a != null) {
                            jSONObject.put("raw_id", Base64.encodeToString(this.f14571a, 2));
                        }
                        jSONObject.put("lst_conf_ver", this.f14578h);
                        this.f14579i.f14567d.i("aid.dat", jSONObject.toString(), true);
                        this.f14575e = false;
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
        this.f14568e = new b(this);
    }

    public static String i(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) ? b.a.r.h.a.b("A00", new b.a.r.g.c.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).b(bArr)) : (String) invokeL.objValue;
    }

    @Override // b.a.r.h.a
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f14568e.i() : (String) invokeV.objValue;
    }

    @Override // b.a.r.h.a
    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14568e.e() : (byte[]) invokeV.objValue;
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
    @Override // b.a.r.h.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(a.c cVar) {
        long j;
        boolean z;
        boolean z2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.f14567d = this.f14555a.f("aid");
            this.f14568e.m();
            TrustSubject trustSubject = this.f14556b.f14562c.f38550b;
            boolean z3 = false;
            boolean z4 = true;
            if (trustSubject != null) {
                j = trustSubject.n();
                if (j != this.f14568e.l()) {
                    z = true;
                    z2 = !TextUtils.isEmpty(this.f14568e.i()) || this.f14568e.e() == null || TextUtils.isEmpty(this.f14568e.g());
                    if (!z2 || z) {
                        str = null;
                        C0735a a2 = trustSubject == null ? C0735a.a(trustSubject) : null;
                        str = Settings.Secure.getString(this.f14556b.f14560a.getContentResolver(), IAdRequestParam.ANDROID_ID);
                        if (TextUtils.isEmpty(str)) {
                            str = "000000000";
                        }
                        if (z2) {
                            if (a2 != null) {
                                if (this.f14568e.f(1L) == 0) {
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
                                this.f14568e.k(uuid);
                                str2 = str2 + uuid;
                                this.f14568e.b(1L, 1L);
                            }
                            byte[] a3 = f.a(str2, "utf-8");
                            String i2 = i(a3);
                            this.f14568e.d(a3);
                            this.f14568e.a(System.currentTimeMillis());
                            this.f14568e.c(str);
                            this.f14568e.h(i2);
                        }
                        this.f14568e.j(j);
                        this.f14568e.n();
                    }
                    return;
                }
            } else {
                j = 0;
            }
            z = false;
            if (TextUtils.isEmpty(this.f14568e.i())) {
            }
            if (z2) {
            }
            str = null;
            if (trustSubject == null) {
            }
            str = Settings.Secure.getString(this.f14556b.f14560a.getContentResolver(), IAdRequestParam.ANDROID_ID);
            if (TextUtils.isEmpty(str)) {
            }
            if (z2) {
            }
            if (z3) {
            }
            this.f14568e.j(j);
            this.f14568e.n();
        }
    }
}
