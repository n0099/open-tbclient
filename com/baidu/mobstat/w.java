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
/* loaded from: classes2.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public static w a;
    public transient /* synthetic */ FieldHolder $fh;
    public Context b;
    public JSONObject c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public String p;
    public String q;

    public w(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new JSONObject();
        this.d = 24L;
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.h = 5L;
        this.i = 24L;
        this.j = 15L;
        this.k = 15L;
        this.l = 30L;
        this.m = 12L;
        this.n = 1L;
        this.o = 24L;
        this.p = "";
        this.q = "";
        this.b = context;
        m();
        j();
        k();
    }

    public static w a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (a == null) {
                synchronized (w.class) {
                    if (a == null) {
                        a = new w(context);
                    }
                }
            }
            return a;
        }
        return (w) invokeL.objValue;
    }

    private long b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, this, j)) == null) {
            if (j - System.currentTimeMillis() > 0) {
                return 0L;
            }
            return j;
        }
        return invokeJ.longValue;
    }

    private void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            String a2 = bn.a(this.b, y.d);
            try {
                if (!TextUtils.isEmpty(a2)) {
                    this.c = new JSONObject(a2);
                }
            } catch (Exception unused) {
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.e != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d * 60 * 60 * 1000;
        }
        return invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.o * 60 * 60 * 1000;
        }
        return invokeV.longValue;
    }

    public long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h * 60 * 1000;
        }
        return invokeV.longValue;
    }

    public long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.i * 60 * 60 * 1000;
        }
        return invokeV.longValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.j * 24 * 60 * 60 * 1000;
        }
        return invokeV.longValue;
    }

    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k * 24 * 60 * 60 * 1000;
        }
        return invokeV.longValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.m * 60 * 60 * 1000;
        }
        return invokeV.longValue;
    }

    public long a(g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, gVar)) == null) {
            long j = gVar.j;
            try {
                String str = gVar.toString();
                if (this.c.has(str)) {
                    j = this.c.getLong(str);
                }
            } catch (Exception e) {
                ba.c().a(e);
            }
            return b(j);
        }
        return invokeL.longValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            bn.a(this.b, ".sign", str, false);
            k();
        }
    }

    public void a(g gVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gVar, j) == null) {
            gVar.j = j;
            try {
                this.c.put(gVar.toString(), j);
            } catch (Exception e) {
                ba.c().a(e);
            }
            try {
                bn.a(this.b, y.d, this.c.toString(), false);
            } catch (Exception e2) {
                ba.c().a(e2);
            }
        }
    }

    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            bn.a(this.b, ".config2", str, false);
            j();
        }
    }

    public boolean a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            return simpleDateFormat.format(Long.valueOf(j)).equals(simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())));
        }
        return invokeJ.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            try {
                String str = new String(bv.b(false, bq.a(), bo.a(bn.a(this.b, ".config2").getBytes())));
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.e = jSONObject.getLong("c");
                } catch (JSONException e) {
                    ba.c().b(e);
                }
                try {
                    this.h = jSONObject.getLong("d");
                } catch (JSONException e2) {
                    ba.c().b(e2);
                }
                try {
                    this.i = jSONObject.getLong("e");
                } catch (JSONException e3) {
                    ba.c().b(e3);
                }
                try {
                    this.j = jSONObject.getLong("i");
                } catch (JSONException e4) {
                    ba.c().b(e4);
                }
                try {
                    this.d = jSONObject.getLong("f");
                } catch (JSONException e5) {
                    ba.c().b(e5);
                }
                try {
                    this.o = jSONObject.getLong("s");
                } catch (JSONException e6) {
                    ba.c().b(e6);
                }
                try {
                    this.k = jSONObject.getLong(PushConstants.URI_PACKAGE_NAME);
                } catch (JSONException e7) {
                    ba.c().b(e7);
                }
                try {
                    this.l = jSONObject.getLong("at");
                } catch (JSONException e8) {
                    ba.c().b(e8);
                }
                try {
                    this.m = jSONObject.getLong("as");
                } catch (JSONException e9) {
                    ba.c().b(e9);
                }
                try {
                    this.n = jSONObject.getLong("ac");
                } catch (JSONException e10) {
                    ba.c().b(e10);
                }
                try {
                    this.f = jSONObject.getLong(Config.DEVICE_MAC_ID);
                } catch (JSONException e11) {
                    ba.c().b(e11);
                }
                try {
                    this.g = jSONObject.getLong("lsc");
                } catch (JSONException e12) {
                    ba.c().b(e12);
                }
            } catch (Exception e13) {
                ba.c().b(e13);
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            try {
                String str = new String(bv.b(false, bq.a(), bo.a(bn.a(this.b, ".sign").getBytes())));
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.q = jSONObject.getString("sign");
                } catch (Exception e) {
                    ba.c().b(e);
                }
                try {
                    this.p = jSONObject.getString("ver");
                } catch (Exception e2) {
                    ba.c().b(e2);
                }
            } catch (Exception e3) {
                ba.c().b(e3);
            }
        }
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long a2 = a(g.h);
            long d = d();
            ba c = ba.c();
            c.a("canSend now=" + currentTimeMillis + ";lastSendTime=" + a2 + ";sendLogTimeInterval=" + d);
            if (currentTimeMillis - a2 <= d && a(a2)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
