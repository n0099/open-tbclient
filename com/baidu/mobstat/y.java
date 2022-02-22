package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.text.SimpleDateFormat;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public static y a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Context f37147b;

    /* renamed from: c  reason: collision with root package name */
    public JSONObject f37148c;

    /* renamed from: d  reason: collision with root package name */
    public long f37149d;

    /* renamed from: e  reason: collision with root package name */
    public long f37150e;

    /* renamed from: f  reason: collision with root package name */
    public long f37151f;

    /* renamed from: g  reason: collision with root package name */
    public long f37152g;

    /* renamed from: h  reason: collision with root package name */
    public long f37153h;

    /* renamed from: i  reason: collision with root package name */
    public long f37154i;

    /* renamed from: j  reason: collision with root package name */
    public long f37155j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public String p;
    public String q;

    public y(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f37148c = new JSONObject();
        this.f37149d = 24L;
        this.f37150e = 0L;
        this.f37151f = 0L;
        this.f37152g = 0L;
        this.f37153h = 5L;
        this.f37154i = 24L;
        this.f37155j = 15L;
        this.k = 15L;
        this.l = 30L;
        this.m = 12L;
        this.n = 1L;
        this.o = 24L;
        this.p = "";
        this.q = "";
        this.f37147b = context;
        m();
        j();
        k();
    }

    public static y a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                synchronized (y.class) {
                    if (a == null) {
                        a = new y(context);
                    }
                }
            }
            return a;
        }
        return (y) invokeL.objValue;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            String b2 = bo.b("backups/system/.timestamp");
            try {
                if (TextUtils.isEmpty(b2)) {
                    return;
                }
                this.f37148c = new JSONObject(b2);
            } catch (Exception unused) {
            }
        }
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37151f != 0 : invokeV.booleanValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f37149d * 60 * 60 * 1000 : invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.o * 60 * 60 * 1000 : invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f37153h * 60 * 1000 : invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f37154i * 60 * 60 * 1000 : invokeV.longValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f37155j * 24 * 60 * 60 * 1000 : invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.k * 24 * 60 * 60 * 1000 : invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m * 60 * 60 * 1000 : invokeV.longValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            try {
                String str = new String(bv.b(false, br.a(), bp.a(bo.a(this.f37147b, ".config2").getBytes())));
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.f37150e = jSONObject.getLong("c");
                } catch (JSONException e2) {
                    bb.c().b(e2);
                }
                try {
                    this.f37153h = jSONObject.getLong("d");
                } catch (JSONException e3) {
                    bb.c().b(e3);
                }
                try {
                    this.f37154i = jSONObject.getLong("e");
                } catch (JSONException e4) {
                    bb.c().b(e4);
                }
                try {
                    this.f37155j = jSONObject.getLong("i");
                } catch (JSONException e5) {
                    bb.c().b(e5);
                }
                try {
                    this.f37149d = jSONObject.getLong("f");
                } catch (JSONException e6) {
                    bb.c().b(e6);
                }
                try {
                    this.o = jSONObject.getLong("s");
                } catch (JSONException e7) {
                    bb.c().b(e7);
                }
                try {
                    this.k = jSONObject.getLong(PushConstants.URI_PACKAGE_NAME);
                } catch (JSONException e8) {
                    bb.c().b(e8);
                }
                try {
                    this.l = jSONObject.getLong("at");
                } catch (JSONException e9) {
                    bb.c().b(e9);
                }
                try {
                    this.m = jSONObject.getLong("as");
                } catch (JSONException e10) {
                    bb.c().b(e10);
                }
                try {
                    this.n = jSONObject.getLong("ac");
                } catch (JSONException e11) {
                    bb.c().b(e11);
                }
                try {
                    this.f37151f = jSONObject.getLong("mc");
                } catch (JSONException e12) {
                    bb.c().b(e12);
                }
                try {
                    this.f37152g = jSONObject.getLong("lsc");
                } catch (JSONException e13) {
                    bb.c().b(e13);
                }
            } catch (Exception e14) {
                bb.c().b(e14);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            try {
                String str = new String(bv.b(false, br.a(), bp.a(bo.a(this.f37147b, ".sign").getBytes())));
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.q = jSONObject.getString("sign");
                } catch (Exception e2) {
                    bb.c().b(e2);
                }
                try {
                    this.p = jSONObject.getString("ver");
                } catch (Exception e3) {
                    bb.c().b(e3);
                }
            } catch (Exception e4) {
                bb.c().b(e4);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long a2 = a(g.f37122h);
            long d2 = d();
            bb c2 = bb.c();
            c2.a("canSend now=" + currentTimeMillis + ";lastSendTime=" + a2 + ";sendLogTimeInterval=" + d2);
            return currentTimeMillis - a2 > d2 || !a(a2);
        }
        return invokeV.booleanValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            bo.a(this.f37147b, ".sign", str, false);
            k();
        }
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) ? (TextUtils.isEmpty(this.p) || !this.p.equals(str) || TextUtils.isEmpty(this.q)) ? "" : this.q : (String) invokeL.objValue;
    }

    private long b(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j2)) == null) {
            if (j2 - System.currentTimeMillis() > 0) {
                return 0L;
            }
            return j2;
        }
        return invokeJ.longValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f37150e != 0 : invokeV.booleanValue;
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            bo.a(this.f37147b, ".config2", str, false);
            j();
        }
    }

    public long a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            long j2 = gVar.f37124j;
            try {
                String str = gVar.toString();
                if (this.f37148c.has(str)) {
                    j2 = this.f37148c.getLong(str);
                }
            } catch (Exception e2) {
                bb.c().a(e2);
            }
            return b(j2);
        }
        return invokeL.longValue;
    }

    public void a(g gVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, j2) == null) {
            gVar.f37124j = j2;
            try {
                this.f37148c.put(gVar.toString(), j2);
            } catch (Exception e2) {
                bb.c().a(e2);
            }
            try {
                bo.a("backups/system/.timestamp", this.f37148c.toString(), false);
            } catch (Exception e3) {
                bb.c().a(e3);
            }
        }
    }

    public boolean a(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            return simpleDateFormat.format(Long.valueOf(j2)).equals(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
        }
        return invokeJ.booleanValue;
    }
}
